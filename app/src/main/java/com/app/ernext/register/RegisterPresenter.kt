package com.app.ernext.register

import android.content.Context
import android.util.Log
import com.app.ernext.R
import com.app.ernext.others.AppData
import com.app.ernext.others.Constants
import com.app.ernext.others.showToast
import com.app.ernext.register.servicecall.RegisterRepository
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RegisterPresenter(viewSignup: RegisterContract.View,
                        context: Context,
                        private val signUpRepository: RegisterRepository, private val appData:AppData) :
        RegisterContract.Presenter {

    var viewSignup: RegisterContract.View
    var context: Context
    private var disposable: Disposable? = null
    val TAG = "RegisterPresenter"

    init {
        this.context = context
        this.viewSignup = viewSignup
        viewSignup.setPresenter(this)
    }

    override fun checkFieldsValidation(name: String,
                                       email: String,
                                       password: String,
                                       countrycode: String,
                                       phoneno: String,
                                       isChecked: Boolean): Boolean {

        if (name.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptyNameField))
            return false
        }

        if (email.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptyEmailIdField))
            return false
        } else {
        }

        if (password.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptycpassword))
            return false
        } else {
        }

        if (countrycode.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptycountrycode))
            return false
        } else {
        }

        if (phoneno.trim().length == 0) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptycphonenumber))
            return false
        } else {
        }

        if (isChecked == false) {
            viewSignup.fieldsValidationFailed(viewSignup.getContext().getString(R.string.emptytermscondition))
            return false
        } else {
        }

        return true

    }

    override fun getDefaultCountryCode() {
    }

    override fun signupUser(name: String,
                            email: String,
                            password: String,
                            isdCode: String,
                            mobile: String,
                            mode: String,
                            device_token: String,
                            device_id: String,
                            device_type: String) {

        if (!viewSignup.isNetworkAvailable()) {
            viewSignup.showNetworkUnavailableMsg()
            return
        }

        viewSignup.handleProgressAlert(true)
        disposable = signUpRepository.callLoginApi(name, email, password, isdCode, mobile, mode,device_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // Log.e(TAG, it.Response().data.toString() +"\n"+it.Response().salt.toString())
                    viewSignup.handleProgressAlert(false)
                    if (it.status.equals("1")) {
                        appData.user_id=it.data!!.user_id!!
                        appData.user_mobile=it.data!!.user_mobile!!
                        appData.user_name=it.data!!.user_name!!
                        appData.user_email=it.data!!.user_email!!
                        appData.user_email=it.data!!.user_email!!
                        viewSignup.goToNextPage()
                    }else{
                        showToast(context,it.msg.toString())
                    }

                }, {
                    Log.e(TAG, it.toString())
                    if (viewSignup.isActivityRunning()) {
                        viewSignup.handleProgressAlert(false)
                        if (viewSignup.isNetworkAvailable())
                            viewSignup.showSomeErrorOccurredMsg(viewSignup.getContext().getString(R.string.someErrorOccurred))
                        else viewSignup.showNetworkUnavailableMsg()
                    }
                })
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