package com.app.ernext.register.servicecall

import com.app.ernext.others.APIService
import com.app.ernext.others.Constants
import com.app.ernext.register.model.RegisterRequest
import com.app.ernext.register.model.RegisterResponse
import io.reactivex.Observable
import retrofit2.http.Query

class RegisterRepository(private val apiService: APIService) {

    fun callLoginApi(fullname:String,
                     email:String,
                     password: String,
                     isdCode:String,
                     phoneNo: String,
                     mode:String,
                     device_token:String): Observable<RegisterResponse> {

        /* Model class to pass data */
        return apiService.callSignUpAPI(
                fullname,
                email,
                password,
                isdCode,
                phoneNo,
                mode,
                device_token,
                "0000",
                Constants.Keys.DEVICE_TYPE)
    }



}