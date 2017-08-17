package com.witanowski.biokod.ui.products;

import android.util.Log;

import com.witanowski.biokod.data.model.Product;
import com.witanowski.biokod.data.model.ProductParams;
import com.witanowski.biokod.data.remote.APIService;
import com.witanowski.biokod.data.remote.APIUtils;
import com.witanowski.biokod.ui.products.adapter.ProductAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public class ProductsInteractorImpl implements ProductsInteractor {
    @Override
    public void getProducts(final OnGetProductsFinishedListener listener) {
        Log.d("testtest", "zxc");
        Product product = new Product("12345", "2.0", new ProductParams(), "products_list");

        APIService service = APIUtils.getAPIService();
        Call<Product> call = service.getProducts(product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(response.isSuccessful()) {
                    listener.onSuccess(response.body().getResult());
                }
                else
                    listener.onFailure();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}
