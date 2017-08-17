package com.witanowski.biokod.ui.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.witanowski.biokod.R;
import com.witanowski.biokod.data.local.PrefUtils;
import com.witanowski.biokod.ui.products.ProductsFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public class LoginFragment extends Fragment implements LoginView, View.OnClickListener {

    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.edtEmail) EditText edtEmail;
    @BindView(R.id.edtPassword) EditText edtPassword;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    private LoginPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, rootView);

        presenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                presenter.validateCredentials(edtEmail.getText().toString(), edtPassword.getText().toString());
                break;
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setFailure() {
        Toast.makeText(getActivity(), getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProducts(String token) {
        PrefUtils.saveToken(getActivity(), token);

        ProductsFragment fragment = new ProductsFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
