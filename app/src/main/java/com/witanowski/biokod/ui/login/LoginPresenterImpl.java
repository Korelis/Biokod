package com.witanowski.biokod.ui.login;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String email, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(email, password, this);
    }

    @Override
    public void onFailure() {
        if(loginView != null) {
            loginView.hideProgress();
            loginView.setFailure();
        }
    }

    @Override
    public void onSuccess(String token) {
        if(loginView != null) {
            loginView.showProducts(token);
        }
    }
}
