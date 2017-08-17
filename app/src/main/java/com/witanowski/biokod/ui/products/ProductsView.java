package com.witanowski.biokod.ui.products;

import com.witanowski.biokod.data.model.ProductResult;

import java.util.List;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public interface ProductsView {
    void showProgress();

    void hideProgress();

    void setFailure();

    void showProducts(List<ProductResult> products);
}
