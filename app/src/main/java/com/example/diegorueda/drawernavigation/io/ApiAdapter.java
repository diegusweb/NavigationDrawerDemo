package com.example.diegorueda.drawernavigation.io;

import android.database.Observable;

import com.example.diegorueda.drawernavigation.io.model.HypedCountryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by diego.rueda on 9/4/2015.
 */
public class ApiAdapter {

    private static ApiService API_SERVICE;

    private static String ROOT = "https://restcountries.eu/rest/v1";

    //SIngleton para cre el api desde cero
    public static ApiService getApiService () {

        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ROOT)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                   // .setConverter(buildLastFmApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(ApiService.class);
        }

        return API_SERVICE;

    }

    private static GsonConverter buildLastFmApiGsonConverter() {
        Gson gson = new GsonBuilder().create();

        return new GsonConverter(gson);
    }

}
