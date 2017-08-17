package com.witanowski.biokod.data.model;

import java.util.List;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public class Product {

    private String id;

    private String jsonrpc;

    private ProductParams params;

    private String method;

    private List<ProductResult> result = null;

    public Product(String id, String jsonrpc, ProductParams params, String method){
        this.id = id;
        this.jsonrpc = jsonrpc;
        this.params = params;
        this.method = method;
    }

    public List<ProductResult> getResult() {
        return result;
    }

}
