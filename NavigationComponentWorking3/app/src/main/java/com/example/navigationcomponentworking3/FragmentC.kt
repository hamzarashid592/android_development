package com.example.navigationcomponentworking3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_c.view.*


class FragmentC : Fragment() {

    val args : FragmentCArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_c, container, false)

        view.text_view_username.text=args.username
        view.text_view_password.text=args.password

        view.btn_go_home.setOnClickListener {
            val navDirections=FragmentCDirections.actionFragmentCToFragmentA()
            findNavController().navigate(navDirections)
        }

        return view
    }


}