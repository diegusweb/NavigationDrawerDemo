package com.example.diegorueda.drawernavigation.ui.io;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by diego.rueda on 9/4/2015.
 */
public class ApiAdapter {

    private static ApiService API_SERVICE;

    private static String ROOT = "http://pastebin.com";

   /* public List<Country> GetAllCountries() {

        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ROOT)
                .setConverter(new GsonConverter(gson))
                .build();

        ApiService service = restAdapter.create(ApiService.class);

        List<Country> countrylist = service.getCountries();

        return countrylist;
    }*/


    //SIngleton para cre el api desde cero
    public static ApiService getApiService () {

        if(API_SERVICE == null){
            Log.d("DiegoResult:", "getApiService");
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ROOT)
                    //.setLogLevel(RestAdapter.LogLevel.BASIC)
                    //.setConverter(buildLastFmApiGsonConverter())
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
