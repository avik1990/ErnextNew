package com.app.ernext.register.servicecall

import com.app.ernext.others.APIService
import com.app.ernext.others.RetrofitClient

object RegisterProvider {

    fun getLoginRepository(): RegisterRepository {
        return RegisterRepository(RetrofitClient.getClient()!!.create(APIService::class.java))
    }
}