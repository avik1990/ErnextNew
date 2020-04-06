package com.app.ernext.fragments.chefdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.app.ernext.BaseFragment
import com.app.ernext.R

class DishesFragment :BaseFragment(){

    companion object {
        const val CLASS_NAME = "DishesFragment"
        fun newInstance(): Fragment {
            return DishesFragment()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.fragment_about
    }

    override fun initResources(view: View, savedInstanceState: Bundle?) {
    }

    override fun initListeners() {
    }
}