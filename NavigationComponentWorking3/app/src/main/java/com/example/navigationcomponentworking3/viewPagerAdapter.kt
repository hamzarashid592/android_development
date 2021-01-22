package com.example.navigationcomponentworking3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewPagerAdapter(
    val fragementList : ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
):FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return fragementList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragementList[position]
    }


}