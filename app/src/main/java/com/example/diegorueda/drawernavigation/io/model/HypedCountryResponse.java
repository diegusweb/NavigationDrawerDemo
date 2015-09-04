package com.example.diegorueda.drawernavigation.io.model;

import com.example.diegorueda.drawernavigation.model.Country;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by diego.rueda on 9/4/2015.
 */
public class HypedCountryResponse {
    @SerializedName("countries")
    private MainResponse mainResponse;

    public ArrayList<Country> getArtists(){
        return  mainResponse.artists;
    }

    public void setArtists(ArrayList<Country> artists) {
        mainResponse.artists = artists;
    }

    private class MainResponse {

        private ArrayList<Country> artists;

    }
}
