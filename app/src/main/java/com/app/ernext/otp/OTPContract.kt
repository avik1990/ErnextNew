package com.app.ernext.otp

import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import com.app.ernext.others.BasePresenter
import com.app.ernext.others.BaseView

interface OTPContract {

    interface Presenter : BasePresenter {
        fun validateOTP(userId: String,
                       otp: String,
                       deviceType: String,
                        deviceID: String)

        fun validateOtp(otp: String)
        fun resendOtp(phoneno: String)
        fun stopTimer()
        fun startTimer()
        fun otpafterrigistration()
        fun otpafterlogin()
    }

    interface View : BaseView<Presenter> {
        fun updateSecsText(text: String)
        fun updateTimerCount(count: String)
        fun enableResendOTP()
        fun disableResendOTP()
        fun gotoResetPasscodeScreen()
        fun gotoDashboardScreen()
        fun showMobileNumberOnScreen(number: String)
        fun handleProgressAlert(showingStatus: Boolean)
    }


}