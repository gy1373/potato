package com.example.blaisdell2.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blaisdell2.eventapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by justin on 7/28/15.
 * Fragment that displays events on an embedded map fragment. The map is a Google Map acquired from the
 * Google Map API.
 */
public class EventMapFragment extends Fragment {

    private GoogleMap mMap;

    public EventMapFragment() {
        // empty constructor for view pager usage
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.event_map)).getMap();
        if(mMap != null)
        {
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.getUiSettings().setZoomGesturesEnabled(true);
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



}
