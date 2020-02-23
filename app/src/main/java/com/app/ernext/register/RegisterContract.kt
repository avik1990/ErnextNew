package com.app.ernext.register

import android.content.Context
import android.telephony.TelephonyManager
import com.app.ernext.others.BasePresenter
import com.app.ernext.others.BaseView

interface RegisterContract {

    interface Presenter : BasePresenter {

        fun checkFieldsValidation(name: String, email: String,password: String, countrycode: String, phoneno: String,
                                  isChecked: Boolean): Boolean

        fun getDefaultCountryCode()

        fun signupUser(name: String,
                       email: String,
                       password: String,
                       isdCode: String,
                       mobile: String,
                       mode: String,
                       device_token: String,
                       device_id: String,
                       device_type: String)

        fun goToPrivacyPolicy()
        fun checkTermsConditions()
    }

    interface View : BaseView<Presenter> {
        fun getContext(): Context
        fun getCountryCodesArray(): Array<String> // From strings.xml file
        fun getTelephonyManager(): TelephonyManager // Get telephony manager
        fun showDefaultCountryCode(code: String) // To show default country code selected at first
        fun handleProgressAlert(showingStatus: Boolean) // true --> show, false --> dismiss
        /* Handle validations */
        fun fieldsValidationFailed(msg: String)
    }


}