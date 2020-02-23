package com.app.ernext.otp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import android.widget.Toast
import com.app.ernext.BaseActivity
import com.app.ernext.R
import com.app.ernext.activity.LoginActivity
import com.app.ernext.customUiComponents.PasscodeHandler
import com.app.ernext.fragments.home.Homefragment
import com.app.ernext.home.Dashboard
import com.app.ernext.others.Constants
import com.app.ernext.others.Utils
import com.app.ernext.others.showToast
import com.app.ernext.register.servicecall.RegisterProvider
import kotlinx.android.synthetic.main.activity_otp.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.rl_signup
import kotlinx.android.synthetic.main.activity_register.tv_register
import kotlinx.android.synthetic.main.enter_otp_layout.*

class OTPActivity : BaseActivity(), View.OnClickListener, OTPContract.View,PasscodeHandler.PasscodeListener {

    var contex: Context? = null
    lateinit var enterOtpPresenter: OTPPresenter

    override fun initResources() {
        contex = this
        OTPPresenter(this, contex!!,RegisterProvider.getLoginRepository()).start()
        PasscodeHandler(etOtp1, etOtp2, etOtp3, etOtp4, this)
    }

    override fun initListeners() {
    }

  /*  private fun registerUser() {
        if(enterOtpPresenter.checkFieldsValidation(et_name.text.toString().trim(),et_email.text.toString().trim(),
                et_password.text.toString().trim(),
                et_isd.text.toString().trim(),et_number.text.toString().trim(),
                isPrivacyChecked)){

            enterOtpPresenter.signupUser(et_name.text.toString().trim(),et_email.text.toString().trim(),
                    et_password.text.toString().trim(),
                    et_isd.text.toString().trim(),et_number.text.toString().trim(),"direct",
                    "ssfhb23",
                    "0000","A")
        }
    }*/

    override fun getLayout(): Int {
        return R.layout.activity_otp
    }

    override fun initPermissions() {
    }

    override fun onClick(v: View?) {

    }

    override fun goToNextPage() {
        Utils.hideKeyboard(this)
        val intent = Intent(contex, Dashboard::class.java)
        intent.putExtra(Constants.Keys.KEY_FRAGMENT_NAME, Homefragment.CLASS_NAME)
        startActivity(intent)
        finish()
    }

    override fun isFragmentAlive(): Boolean {
        return false
    }

    override fun isActivityRunning(): Boolean {
        return true
    }

    override fun setPresenter(presenter: OTPContract.Presenter) {
        enterOtpPresenter = presenter as OTPPresenter
        enterOtpPresenter.startTimer()
    }

    override fun isNetworkAvailable(): Boolean {
        return Utils.isConnectedToNetwork(this)
    }

    override fun showNetworkUnavailableMsg() {
        Toast.makeText(contex, "", Toast.LENGTH_SHORT).show()
    }

    override fun showSomeErrorOccurredMsg(msg: String) {
        Toast.makeText(contex, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onResult(status: Boolean) {
        if (status) {
            btSubmitEnterOtp.performClick()
        }
    }

    override fun gotoResetPasscodeScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun gotoDashboardScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleProgressAlert(showingStatus: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun updateTimerCount(count: String) {
        tvTimer.text = count
    }

    override fun updateSecsText(text: String) {
        tvSecs.text = text
    }

    override fun enableResendOTP() {
        llDidntReceiveOtpResend.alpha = 1.0F
        tvResendOtp.isEnabled = true
    }

    override fun disableResendOTP() {
        llDidntReceiveOtpResend.alpha = 0.4F
        tvResendOtp.isEnabled = false
    }

    override fun showMobileNumberOnScreen(number: String) {
        tvOtpSentMsg.text = String.format(getString(R.string.otpSentMsg, number))
    }
}
