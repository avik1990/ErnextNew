package com.app.ernext.otp

import android.content.Context
import android.os.Handler
import android.util.Base64
import android.util.Log
import com.app.ernext.R
import com.app.ernext.others.Constants
import com.app.ernext.others.showToast
import com.app.ernext.register.servicecall.RegisterRepository
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class OTPPresenter(private val view: OTPContract.View, private val context: Context, private val enterOTPRepository: RegisterRepository) :
        OTPContract.Presenter {
    override fun signupUser(name: String, email: String, password: String, isdCode: String, mobile: String, mode: String, device_token: String, device_id: String, device_type: String) {
    }

    //lateinit var view: OTPContract.View
    var mobileNumber: String? = ""
    var handler: Handler
    private var disposable: Disposable? = null
    val TAG = "EnterOtpPresenter"

    companion object {
        var counter = 60
    }

    init {
        handler = Handler()

    }

    override fun validateOtp(otp: String) {
        //Log.d("FragmentName", fragmentName)
       /* if (fragmentName.equals(EnterMobileForgotPasscodeFragment.CLASS_NAME)) {
            VerifyOTP(otp)
        } else if (fragmentName.equals(SignupActivity.CLASS_NAME)) {
            loginafterrigistration(otp)
        } else if (fragmentName.equals(LoginActivity.CLASS_NAME)) {
            VerifyOTP(otp)
        } else if (fragmentName.equals(LoginActivity.CLASS_NAME_203)) {
            forceloginApicall(otp)
        }*/
    }

    override fun start() {
        //mobileNumber?.let { view.showMobileNumberOnScreen(it) }
        view.setPresenter(this)
    }

    override fun stop() {
        counter = 60
        stopTimer()
        disposable?.dispose()
        view.handleProgressAlert(false)
    }

    override fun stopTimer() {
        handler.removeCallbacks(runnable)
    }

    override fun startTimer() {
        handler.postDelayed(runnable, 1000)
    }

    var runnable: Runnable = Runnable {
        if (counter > 0) {
            counter -= 1
            view.disableResendOTP()
            if (counter < 10) {
                view.updateTimerCount("0" + counter.toString())
            } else {
                view.updateTimerCount(counter.toString())
            }

            if (counter < 2) view.updateSecsText("second")
            else view.updateSecsText("seconds")
            startTimer()
        } else if (counter == 0) {
            stop()
            view.enableResendOTP()
        }
    }

    override fun otpafterrigistration() {
       /* if (!view.isNetworkAvailable()) {
            view.showNetworkUnavailableMsg()
            return
        }
        view.handleProgressAlert(true)
        // if (view.isFragmentAlive()) {
        disposable = enterOTPRepository.getotpafterrigistrationRepositoryApi(appData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // Log.e(TAG, it.Response().data.toString() +"\n"+it.Response().salt.toString())
                    view.handleProgressAlert(false)
                    if (!it.response.data.isEmpty()) {
                        val json = AESCrypt.decrypt(Base64.decode(it.response.salt, Base64.NO_WRAP), it.response.data)
                        Log.d("json", json)
                        val obj = JSONObject(AESCrypt.decrypt(Base64.decode(it.response.salt, Base64.NO_WRAP), it.response.data))
                        if (obj.get("responseCode").toString().equals("201")) {
                            view.showSomeErrorOccurredMsg(obj.get("responseDetails") as String)
                        } else if (obj.get("responseCode").toString().equals("200")) {
                            //val signupresponsesucess = GsonBuilder().create().fromJson(json, EnterOTPResponseSucess::class.java)
                            view.showSomeErrorOccurredMsg(obj.get("responseDetails") as String)
                            *//*if (view.isActivityRunning()) {
                                view.goToNextPage()
                            }*//*
                        } else if (obj.get("responseCode").toString().equals("403")) {
                            view.showSomeErrorOccurredMsg("The Email OR Phone field is required")
                        } else if (obj.get("responseCode").toString().equals("408")) {
                            view.showSomeErrorOccurredMsg(obj.get("responseDetails") as String)
                        } else if (obj.get("responseCode").toString().equals("401")) {
                            view.showSomeErrorOccurredMsg(obj.get("responseDetails") as String)
                        }
                    }

                }, {
                    Log.e(TAG, it.toString())
                    if (view.isActivityRunning()) {
                        view.handleProgressAlert(false)
                        if (view.isNetworkAvailable())
                            view.showSomeErrorOccurredMsg("Something went wrong")
                        else view.showNetworkUnavailableMsg()
                    }
                })*/
        //}

    }

    override fun resendOtp(phoneno: String) {
        /*if (!view.isNetworkAvailable()) {
            view.showNetworkUnavailableMsg()
            return
        }
        view.handleProgressAlert(true)
        disposable = enterOTPRepository.resendOTP(phoneno)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // Log.e(TAG, it.Response().data.toString() +"\n"+it.Response().salt.toString())
                    view.handleProgressAlert(false)
                    if (!it.response.data.isEmpty()) {
                        val json = AESCrypt.decrypt(Base64.decode(it.response.salt, Base64.NO_WRAP), it.response.data)
                        Log.d("json", json)
                        val obj = JSONObject(AESCrypt.decrypt(Base64.decode(it.response.salt, Base64.NO_WRAP), it.response.data))
                        if (obj.get("responseCode").toString().equals("201")) {
                            view.showSomeErrorOccurredMsg(obj.get("responseDetails") as String)
                        } else if (obj.get("responseCode").toString().equals("200")) {
                            view.showSomeErrorOccurredMsg(obj.get("responseDetails") as String)
                        } else if (obj.get("responseCode").toString().equals("401")) {
                            view.showSomeErrorOccurredMsg("The phone field is required")
                        }
                    }
                }, {
                    if (view.isActivityRunning()) {
                        view.handleProgressAlert(false)
                        if (view.isNetworkAvailable())
                        //view.showSomeErrorOccurredMsg(view.getContext().getString(R.string.someErrorOccurred))
                        else view.showNetworkUnavailableMsg()
                    }
                })*/
    }




    override fun otpafterlogin() {
        /*if (!view.isNetworkAvailable()) {
            view.showNetworkUnavailableMsg()
            return
        }
        view.handleProgressAlert(true)
        // if (view.isFragmentAlive()) {
        disposable = enterOTPRepository.callotpafterloginApi(appData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // Log.e(TAG, it.Response().data.toString() +"\n"+it.Response().salt.toString())
                    view.handleProgressAlert(false)
                    if (!it.response.data.isEmpty())

                }, {
                    Log.e(TAG, it.toString())
                    if (view.isActivityRunning()) {
                        view.handleProgressAlert(false)
                        if (view.isNetworkAvailable())
                            view.showSomeErrorOccurredMsg("Something went wrong")
                        else view.showNetworkUnavailableMsg()
                    }
                })*/
    }
}