package com.example.navigationcomponentworking3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_b.view.*
import kotlinx.android.synthetic.main.fragment_c.view.*


class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_b, container, false)


        view.btn_go.setOnClickListener {

            val username=view.edit_text_username.text.toString()
            val pass=view.edit_text_password.text.toString()

            val navDirections=FragmentBDirections.actionFragmentBToFragmentC(username,pass)
            findNavController().navigate(navDirections)
        }

        return view
    }


}