package com.witanowski.biokod.data.remote;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public class APIUtils {

    public static final String BASE_URL = "http://www.biokod.net:8990/api/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
