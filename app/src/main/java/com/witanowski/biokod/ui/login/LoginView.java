package com.witanowski.biokod.ui.login;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setFailure();

    void showProducts(String token);
}
