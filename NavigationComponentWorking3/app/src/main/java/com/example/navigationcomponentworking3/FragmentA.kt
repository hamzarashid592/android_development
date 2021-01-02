package com.example.navigationcomponentworking3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_a.view.*


class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        view.btn_login.setOnClickListener {
            var navDirections : NavDirections= FragmentADirections.actionFragmentAToFragmentB()
            findNavController().navigate(navDirections)
        }

        return view
    }


}