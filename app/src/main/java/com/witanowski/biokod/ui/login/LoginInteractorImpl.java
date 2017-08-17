package com.witanowski.biokod.ui.login;

import com.witanowski.biokod.data.model.User;
import com.witanowski.biokod.data.model.UserParams;
import com.witanowski.biokod.data.remote.APIService;
import com.witanowski.biokod.data.remote.APIUtils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String email, final String password, final LoginInteractor.OnLoginFinishedListener listener) {

        UserParams params = new UserParams(
                email,
                new String(Hex.encodeHex(DigestUtils.sha256(password)))
        );

        User user = new User(
                params,
                "login",
                "12345",
                "2.0"
        );

        APIService service = APIUtils.getAPIService();
        Call<User> call = service.login(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    if(response.body().getResult() != null) {
                        listener.onSuccess(response.body().getResult().getToken());
                    }
                    else
                        listener.onFailure();
                }
                else
                    listener.onFailure();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}
