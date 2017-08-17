package com.witanowski.biokod.ui.login;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {
        void onFailure();

        void onSuccess(String token);
    }

    void login(String email, String password, OnLoginFinishedListener listener);
}
