package com.example.navigationcomponentworking3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*


class FragmentA : Fragment() {

    val rotate_clockwise by lazy { AnimationUtils.loadAnimation(context,R.anim.rotate_clockwise) }
    val rotate_anticlockwise by lazy { AnimationUtils.loadAnimation(context,R.anim.rotate_anticlockwise) }
    val bottom_up by lazy { AnimationUtils.loadAnimation(context,R.anim.from_bottom) }
    val bottom_down by lazy { AnimationUtils.loadAnimation(context,R.anim.to_bottom) }
    var fab_click_state=false

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

        view.btn_test1.setOnClickListener {
            var navDirections=FragmentADirections.actionFragmentAToFragmentD()
            view.findNavController().navigate(navDirections)
        }

        view.fab1.setOnClickListener {
            fab_click_state=!fab_click_state

            if(fab_click_state==true) {
                fab2.visibility=View.VISIBLE
                fab2.isClickable=true
                fab1.startAnimation(rotate_clockwise)
                fab2.startAnimation(bottom_up)
            }
            else {
                fab2.visibility=View.INVISIBLE
                fab2.isClickable=false
                fab1.startAnimation(rotate_anticlockwise)
                fab2.startAnimation(bottom_down)
            }
        }
        view.fab2.setOnClickListener {
            Toast.makeText(context,"FAB2 clicked",Toast.LENGTH_SHORT).show()
        }

        return view
    }


}