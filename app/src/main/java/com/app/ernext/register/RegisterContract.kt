package com.app.ernext.register

import android.content.Context
import android.telephony.TelephonyManager
import com.app.ernext.others.BasePresenter
import com.app.ernext.others.BaseView

interface RegisterContract {

    interface Presenter : BasePresenter {

        fun checkFieldsValidation(name: String, email: String, countrycode: String, phoneno: String,
                                  password: String, usertype: String, isChecked: Boolean)

        fun getDefaultCountryCode()
        fun signupUser()
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