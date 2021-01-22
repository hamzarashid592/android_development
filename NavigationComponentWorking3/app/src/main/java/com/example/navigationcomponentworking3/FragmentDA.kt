package com.example.navigationcomponentworking3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_da.view.*


class FragmentDA : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_da, container, false)


        view.btn_frag_da.setOnClickListener {
            val navDirections=FragmentDDirections.actionFragmentDToFragmentDC()
            view.findNavController().navigate(navDirections)
        }


        return view
    }


}