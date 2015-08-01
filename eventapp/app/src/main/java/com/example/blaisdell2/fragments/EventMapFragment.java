package com.example.blaisdell2.fragments;


import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blaisdell2.eventapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by justin on 7/28/15.
 * Fragment that displays events on an embedded map fragment. The map is a Google Map acquired from the
 * Google Map API.
 */
public class EventMapFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;


    public EventMapFragment() {
        // empty constructor for view pager usage
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: Check if this api code is actually connecting
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mGoogleApiClient.connect();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.event_map)).getMap();
        if(mMap != null)
        {
            // set map settings here
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

            // not sure if this works, last location ont being set properly? BECAUSE IM NOT IN THE ATLANTIC OCEAN SIR.
            // RIGHT NOW LAST LOCATION IS NULL GGNOREGIVEUP
            if(mLastLocation != null)
            {
                Log.e("YO", "yoooooo");
                LatLng setLatLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(setLatLng, 15.6f));
            }
            else
            {
                // Currently defaults to the illini union, because pretty much center of campus
                LatLng setLatLng = new LatLng(40.109742, -88.227315);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(setLatLng,15.6f));
            }
        }
        return view;
    }



    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        try
        {
            SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.event_map);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.remove(mapFragment);
            ft.commit();
        } catch (Exception e) {

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
