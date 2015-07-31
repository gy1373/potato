package com.example.blaisdell2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blaisdell2.eventapp.R;


public class MainFragment extends Fragment {

    Button testMapFragment;

    public MainFragment() {
        //empty constructor for view pager usage
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        testMapFragment = (Button) view.findViewById(R.id.test_map_frag);
        testMapFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Code to replace the current fragment for testing
                EventMapFragment newFragment = new EventMapFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainActivity_view, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                //end testing code

            }
        });
        return view;
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
