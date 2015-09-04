package com.example.diegorueda.drawernavigation.io;

import com.example.diegorueda.drawernavigation.model.Country;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by diego.rueda on 9/4/2015.
 */
public interface ApiService {
    @GET("/all")
    List<Country> getCountries();
}
