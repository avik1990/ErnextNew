package com.app.ernext.fragments.chefdetails

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(private val fragmentManager: FragmentManager, private val tabCount: Int): FragmentPagerAdapter(fragmentManager) {

    lateinit  var fragmentName: Fragment

    override fun getItem(tabPosition: Int): Fragment {
        when(tabPosition){
            0 -> {
                fragmentName = AboutFragment.newInstance()
            }
            1 -> {
                fragmentName = DishesFragment.newInstance()
            }
            2 -> {
                fragmentName = VideoFragment.newInstance()
            }
            3 -> {
                fragmentName = RestaurantFragment.newInstance()
            }

        }
        return fragmentName
    }

    override fun getCount(): Int {
        return tabCount
    }
}