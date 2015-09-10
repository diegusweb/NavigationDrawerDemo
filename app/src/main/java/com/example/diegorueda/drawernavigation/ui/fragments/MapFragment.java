package com.example.diegorueda.drawernavigation.ui.fragments;


import android.content.Context;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegorueda.drawernavigation.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    private static final LatLng DAVAO = new LatLng(7.0722, 125.6131);
    private GoogleMap map;
    private SupportMapFragment fragment;

    Location location;

    private static final LatLng LOWER_MANHATTAN = new LatLng(40.722543,
            -73.998585);
    private static final LatLng TIMES_SQUARE = new LatLng(40.7577, -73.9857);
    private static final LatLng BROOKLYN_BRIDGE = new LatLng(40.7057, -73.9964);


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_map, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {
            map = fragment.getMap();
            map.addMarker(new MarkerOptions().position(new LatLng(0, 0)));

            map.setMyLocationEnabled(true);
            //map.setBuildingsEnabled(true);


            setLines();

        }
    }

    private void animatingCamera(){

        LatLng SYDNEY = new LatLng(-33.88, 151.21);
        LatLng MOUNTAIN_VIEW = new LatLng(37.4, -122.1);
        // Move the camera instantly to Sydney with a zoom of 15.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SYDNEY, 15));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomIn());

        // Zoom out to zoom level 10, animating with a duration of 2
        // seconds.
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        // Construct a CameraPosition focusing on Mountain View and animate
        // the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(MOUNTAIN_VIEW) // Sets the center of the map to Mountain View
                .zoom(17) // Sets the zoom
                .bearing(90) // Sets the orientation of the camera to east
                .tilt(30) // Sets the tilt of the camera to 30 degrees
                .build(); // Creates a CameraPosition from the builder

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void setCircle(){
        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(37.4, -122.1))
                .radius(1000)
                .strokeColor(Color.GREEN);

        Circle circle = map.addCircle(circleOptions);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4, -122.1), 15));
    }

    private void setLines(){


       LatLng LOWER_UNO = new LatLng(-17.39167010757299, -66.16013467311859);
        LatLng LOWER_DOS= new LatLng(-17.388506428712862, -66.1607676744461);
        LatLng LOWER_TRES = new LatLng(-17.38727780081499, -66.1543196439743);
        LatLng LOWER_CUATRO = new LatLng(-17.38945860965893, -66.15389049053192);

        LatLng LOWER_CINCO = new LatLng(-17.39012410952845, -66.15709841251373);
        LatLng LOWER_SEIS = new LatLng(-17.392059164625778, -66.15666925907135);
        LatLng LOWER_SIETE= new LatLng(-17.39292942067089, -66.16096079349518);

        map.addPolyline((new PolylineOptions())
                .add(LOWER_UNO, LOWER_DOS, LOWER_TRES,
                        LOWER_CUATRO)
                .width(5)
                .color(Color.BLUE)
                .geodesic(true));

        map.addPolyline((new PolylineOptions())
                .add(LOWER_CUATRO,LOWER_CINCO,LOWER_SEIS,LOWER_SIETE)
                .width(5)
                .color(Color.RED)
                .geodesic(true));

        // move camera to zoom on map
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LOWER_UNO, 13));


        /*PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(37.35, -122.0))
                .add(new LatLng(37.45, -122.0))
                .add(new LatLng(37.45, -122.2))
                .add(new LatLng(37.35, -122.2))
                .add(new LatLng(37.35, -122.0))
                .color(Color.BLUE);

        Polyline polyline = mMap.addPolyline(rectOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LOWER_MANHATTAN, 13));*/

    }

    private void setMArker(){
        LatLng NYC = new LatLng(40.714, -74.00);
        map.addMarker(
                new MarkerOptions().position(NYC).alpha(0.8f).title("NYC")
                        .snippet("AndroidSRC Map Demo"))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(NYC, 9));
    }

    private void setUpMap(){
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker").snippet("Snippet"));

        // Enable MyLocation Layer of Google Map
        map.setMyLocationEnabled(true);

        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);

        // set map type
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Get latitude of the current location
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        map.animateCamera(CameraUpdateFactory.zoomTo(16));

        map.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!").snippet("Consider yourself located"));


    }

}
