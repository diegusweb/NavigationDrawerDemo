package com.example.diegorueda.drawernavigation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegorueda.drawernavigation.R;

/**
 * Created by diego.rueda on 9/4/2015.
 */
public class CountryFragment extends Fragment {
    private RecyclerView contryRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);

        contryRecyclerView = (RecyclerView) root.findViewById(R.id.rvCountry);

        return root;
    }

    private void setupContryList(){

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
