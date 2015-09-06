package com.example.diegorueda.drawernavigation.ui.io;

import com.example.diegorueda.drawernavigation.model.AndroidVersion;
import com.example.diegorueda.drawernavigation.model.Country;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by diego.rueda on 9/4/2015.   List<Country> getCountries();
 */
public interface ApiService {
    //@GET("/all")
    //void getCountries(Callback<ContryResponse> serverResponse);
    //@GET("/all")
   // List<Country> getCountries();

    @GET("/raw.php?i=PHPXBsEf")
    void getElements(Callback<List<AndroidVersion>> callback);

    @GET("/all")
    void getCountries(Callback<List<Country>> callback);
}
