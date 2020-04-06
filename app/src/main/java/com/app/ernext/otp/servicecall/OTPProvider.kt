package com.app.ernext.otp.servicecall

import com.app.ernext.others.APIService
import com.app.ernext.others.RetrofitClient

object OTPProvider {

    fun getLoginRepository(): OTPRepository {
        return OTPRepository(RetrofitClient.getClient()!!.create(APIService::class.java))
    }
}