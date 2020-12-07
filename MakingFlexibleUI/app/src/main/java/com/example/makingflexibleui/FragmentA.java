package com.example.makingflexibleui;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentA extends Fragment {

    ListView listView;
    FragmentCommunicator comm;

//    Function to initialize the FragmentCommunicator object.
//    public void initilizeCommunicator(FragmentCommunicator comm){
//        this.comm=comm;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView=getActivity().findViewById(R.id.listView);

        ArrayAdapter adp = ArrayAdapter.createFromResource(getActivity(),R.array.titles, android.R.layout.simple_list_item_1);
        listView.setAdapter(adp);

//        Initializing the communicator.
        comm= (FragmentCommunicator) getActivity();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("HAMZA","Item "+position+" selected");
                    comm.communicator(position);
            }
        });
        Log.d("HAMZA","Fragment A created.");
    }
    public interface FragmentCommunicator{
        public void communicator(Integer data);
    }
}