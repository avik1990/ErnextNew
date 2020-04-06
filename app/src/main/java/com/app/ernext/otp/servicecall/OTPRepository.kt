package com.app.ernext.otp.servicecall

import com.app.ernext.others.APIService
import com.app.ernext.others.Constants
import com.app.ernext.otp.model.OTPResponse
import com.app.ernext.register.model.RegisterRequest
import com.app.ernext.register.model.RegisterResponse
import io.reactivex.Observable
import retrofit2.http.Query

class OTPRepository(private val apiService: APIService) {

    fun callOTPApi(userId: String,
                   otp: String,
                   deviceType: String,
                   deviceID: String): Observable<OTPResponse> {

        /* Model class to pass data */
        return apiService.callOTPAPI(
                userId,
                otp,
                Constants.Keys.DEVICE_TYPE,
                deviceID)
    }

   /* ("user_id") user_id: String,
    @Field("otp") otp: String,
    @Field("device_type") device_type: String,
    @Field("device_id")*/

}