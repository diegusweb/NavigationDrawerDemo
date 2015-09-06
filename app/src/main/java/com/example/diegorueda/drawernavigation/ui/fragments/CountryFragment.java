package com.example.diegorueda.drawernavigation.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegorueda.drawernavigation.MainActivity;
import com.example.diegorueda.drawernavigation.R;
import com.example.diegorueda.drawernavigation.model.AndroidVersion;
import com.example.diegorueda.drawernavigation.ui.io.ApiAdapter;
import com.example.diegorueda.drawernavigation.model.Country;
import com.example.diegorueda.drawernavigation.model.CountryTemp;
import com.example.diegorueda.drawernavigation.ui.adapter.ContryAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by diego.rueda on 9/4/2015.
 */
public class CountryFragment extends Fragment{
    private RecyclerView contryRecyclerView;

    private ContryAdapter adapter;
    //final ContryAdapter androidVersionAdapter = new ContryAdapter();


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DiegoResult:", "CountryFragment");
        adapter = new ContryAdapter(getActivity());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof MainActivity)
            Log.i("Si se ejecuto", "Yes");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);

        contryRecyclerView = (RecyclerView) root.findViewById(R.id.rvCountry);
        setupArtistList();
       // setDummyContent();
        return root;
    }

    private void setupArtistList(){
        contryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //poniendo adaptador
        contryRecyclerView.setAdapter(adapter);
    }



    @Override
    public void onResume() {
        super.onResume();
        Log.d("DiegoResult:", "demooooooooo");
        ApiAdapter.getApiService().getElements(new Callback<List<AndroidVersion>>() {
            @Override
            public void success(List<AndroidVersion> androidVersions, Response response) {
                adapter.addAndroidVersions(androidVersions);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
