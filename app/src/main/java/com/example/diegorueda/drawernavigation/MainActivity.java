package com.example.diegorueda.drawernavigation;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.diegorueda.drawernavigation.ui.fragments.FeedsFragment;
import com.example.diegorueda.drawernavigation.ui.fragments.HomeFragment;
import com.example.diegorueda.drawernavigation.ui.fragments.StoreFragment;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        if(navigationView != null){
            setupDrawerContent(navigationView);
        }
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        String title = menuItem.getTitle().toString();
                        drawerLayout.closeDrawers();
                        //Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();

                        selectDrawerItem(menuItem);

                        return true;
                    }
                }
        );
    }

    private void selectDrawerItem(MenuItem menuItem){
        Fragment fragment = null;
        Toast.makeText(getApplicationContext(), menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
        Class fragmentClass;

        switch(menuItem.getTitle().toString()) {
            case "Productos":
                fragmentClass = StoreFragment.class;
                break;
            case "Home":
                fragmentClass = HomeFragment.class;
                break;
            case "Compras":
                fragmentClass = FeedsFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());

        drawerLayout.closeDrawers();
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
           getMenuInflater().inflate(R.menu.menu_main, menu);
           return true;
       }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case android.R.id.home:
               drawerLayout.openDrawer(GravityCompat.START);
               return true;
       }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}
