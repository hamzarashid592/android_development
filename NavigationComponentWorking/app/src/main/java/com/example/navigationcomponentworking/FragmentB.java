package com.example.navigationcomponentworking;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {

    TextView textView1;
    TextView textView2;

    public FragmentB() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_b, container, false);


        textView1=view.findViewById(R.id.textView1);
        textView2=view.findViewById(R.id.textView2);

        String a=FragmentBArgs.fromBundle(getArguments()).getFullName();
        String b=String.valueOf(FragmentBArgs.fromBundle(getArguments()).getAge());

        textView1.setText(a);
        textView2.setText(b);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.B_to_A);
            }
        });

        return view;
    }
}