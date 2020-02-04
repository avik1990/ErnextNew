package com.app.ernext.register

import android.content.Context
import com.app.ernext.R

class RegisterPresenter(viewSignup: RegisterContract.View, context: Context) : RegisterContract.Presenter {

    var viewSignup: RegisterContract.View
    var context: Context

    init {
        this.context = context
        this.viewSignup = viewSignup
        viewSignup.setPresenter(this)
    }

    override fun checkFieldsValidation(name: String, email: String, countrycode: String, phoneno: String, password: String, usertype: String, isChecked: Boolean) {

        /* Field Order wise validation messages */
        if (name.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptyNameField))
            return
        }

        if (email.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptyEmailIdField))
            return
        } else {
        }

        if (countrycode.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptycountrycode))
            return
        } else {
        }

        if (phoneno.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptycphonenumber))
            return
        } else {
        }

        if (password.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptycpassword))
            return
        } else {
        }

        if (usertype.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptyusertype))
            return
        } else {
        }

        if (isChecked == false) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptytermscondition))
            return
        } else {
        }
        signupUser()
    }

    override fun getDefaultCountryCode() {
    }

    override fun signupUser() {
        // viewSignup.fieldsValidationFailed("Success")
        viewSignup.goToNextPage()
    }

    override fun goToPrivacyPolicy() {
    }

    override fun checkTermsConditions() {
    }

    override fun start() {
    }

    override fun stop() {
    }
}