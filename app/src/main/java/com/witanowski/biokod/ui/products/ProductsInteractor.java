package com.witanowski.biokod.ui.products;

import com.witanowski.biokod.data.model.Product;
import com.witanowski.biokod.data.model.ProductResult;

import java.util.List;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public interface ProductsInteractor {
    interface OnGetProductsFinishedListener {
        void onFailure();

        void onSuccess(List<ProductResult> products);
    }

    void getProducts(OnGetProductsFinishedListener listener);
}
