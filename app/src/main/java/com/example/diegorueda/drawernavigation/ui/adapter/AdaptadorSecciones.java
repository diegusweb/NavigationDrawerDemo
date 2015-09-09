package com.example.diegorueda.drawernavigation.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.rueda on 9/9/2015.
 */
public class AdaptadorSecciones extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentos = new ArrayList<>();
    private final List<String> titulosFragmentos = new ArrayList<>();

    public AdaptadorSecciones(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }

    public void addFragment(android.support.v4.app.Fragment fragment, String title) {
        fragmentos.add(fragment);
        titulosFragmentos.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulosFragmentos.get(position);
    }
}
