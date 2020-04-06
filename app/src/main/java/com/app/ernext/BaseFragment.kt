package com.app.ernext

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.namee.permissiongen.PermissionGen

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutView(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initResources(view, savedInstanceState)
        initListeners()
    }

    abstract fun getLayoutView():Int
    abstract fun initResources(view: View, savedInstanceState: Bundle?)
    abstract fun initListeners()



}