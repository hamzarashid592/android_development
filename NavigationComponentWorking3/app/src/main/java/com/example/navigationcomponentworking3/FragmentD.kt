package com.example.navigationcomponentworking3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_d.view.*
import kotlinx.android.synthetic.main.fragment_da.*


class FragmentD : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_d, container, false)


        val fragList =arrayListOf(FragmentDA(),FragmentDB())

//        Creating the pager adapter.
        val adp=viewPagerAdapter(fragList,requireActivity().supportFragmentManager,lifecycle)

        view.viewPager.adapter=adp


        return view
    }

}