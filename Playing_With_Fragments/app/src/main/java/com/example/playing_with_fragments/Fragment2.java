package com.example.playing_with_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment2 extends Fragment {


    Button button;
    Integer counter=0;
    FragmentCommunicator fc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HAMZA","OnCreate called");
        if (savedInstanceState!=null){
            counter=savedInstanceState.getInt("counter",0);
            Log.d("HAMZA","Fetching the counter value.");
        }
        else{
            Log.d("HAMZA","Initializing the counter value.");
            counter=0;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button=getActivity().findViewById(R.id.fragment2Button);

//        Pointing the communicator object to the object of the main activity.
        fc= (FragmentCommunicator) getActivity();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                fc.setData("The button was clicked "+counter+" times.");
            }
        });
        Log.d("HAMZA","OnActivity Create called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
        Log.d("HAMZA","OnSaveInstanceState called");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d("HAMZA","ONDestroy called.");
    }
}