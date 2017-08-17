package com.witanowski.biokod.data.model;

/**
 * Created by Michal Witanowski on 2017-08-16.
 */

public class User {

    private UserParams params;

    private String method;

    private String id;

    private String jsonrpc;

    private UserResult result;

    public User(UserParams params, String method, String id, String jsonrpc){
        this.params = params;
        this.method = method;
        this.id = id;
        this.jsonrpc = jsonrpc;
    }

    public UserResult getResult(){
        return result;
    }
}
