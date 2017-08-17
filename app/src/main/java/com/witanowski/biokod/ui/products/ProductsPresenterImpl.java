package com.witanowski.biokod.ui.products;

import com.witanowski.biokod.data.model.ProductResult;

import java.util.List;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public class ProductsPresenterImpl implements ProductsPresenter, ProductsInteractor.OnGetProductsFinishedListener {

    private ProductsView productsView;
    private ProductsInteractor productsInteractor;

    public ProductsPresenterImpl(ProductsView productsView){
        this.productsView = productsView;
        this.productsInteractor = new ProductsInteractorImpl();
    }

    @Override
    public void showProducts() {
        if(productsView != null){
            productsView.showProgress();
        }

        productsInteractor.getProducts(this);
    }

    @Override
    public void onFailure() {
        if(productsView != null){
            productsView.hideProgress();
            productsView.setFailure();
        }
    }

    @Override
    public void onSuccess(List<ProductResult> products) {
        if(productsView != null){
            productsView.hideProgress();
            productsView.showProducts(products);
        }
    }
}
