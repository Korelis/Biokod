package com.witanowski.biokod.data.remote;


import com.witanowski.biokod.data.model.Product;
import com.witanowski.biokod.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public interface APIService {
    @POST("users")
    Call<User> login(@Body User user);

    @POST("products")
    Call<Product> getProducts(@Body Product product);
}
