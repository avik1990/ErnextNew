package com.app.ernext.register

import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.view.View
import android.widget.Toast
import com.app.ernext.BaseActivity
import com.app.ernext.R
import com.app.ernext.activity.LoginActivity
import com.app.ernext.fragments.home.Homefragment
import com.app.ernext.home.Dashboard
import com.app.ernext.others.AppData
import com.app.ernext.others.Constants
import com.app.ernext.others.Utils
import com.app.ernext.others.showToast
import com.app.ernext.otp.OTPActivity
import com.app.ernext.register.servicecall.RegisterProvider
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.rl_signup
import kotlinx.android.synthetic.main.activity_register.tv_register

class RegisterActivity : BaseActivity(), View.OnClickListener, RegisterContract.View {

    var contex: Context? = null
    lateinit var signupPresenter: RegisterPresenter
    var isPrivacyChecked: Boolean = false
    var isUserTypeChecked: Boolean = false
    var userType: String = ""
    lateinit var appData: AppData

    override fun initResources() {
        contex = this
        appData = AppData(contex!!, Constants.Keys._KeyCryptoPreference)
        RegisterPresenter(this, contex!!,RegisterProvider.getLoginRepository(),appData).start()

    }

    override fun initListeners() {
        rl_signup.setOnClickListener {
            val i = Intent(contex, LoginActivity::class.java)
            startActivity(i)
        }
        tv_register.setOnClickListener {
            goToNextPage()
        }
        tv_signin.setOnClickListener {
            val i = Intent(contex, Dashboard::class.java)
            startActivity(i)
        }

        btn_register.setOnClickListener {

           registerUser()
        }

        chk_box.setOnCheckedChangeListener { compoundButton, isChecked ->
            isPrivacyChecked = isChecked
        }
    }

    private fun registerUser() {
        if(signupPresenter.checkFieldsValidation(et_name.text.toString().trim(),et_email.text.toString().trim(),
                et_password.text.toString().trim(),
                et_isd.text.toString().trim(),et_number.text.toString().trim(),
                isPrivacyChecked)){

            signupPresenter.signupUser(et_name.text.toString().trim(),et_email.text.toString().trim(),
                    et_password.text.toString().trim(),
                    et_isd.text.toString().trim(),et_number.text.toString().trim(),"direct",
                    "ssgsgsgsgs453dfgf",
                    "0000000000","A")
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    override fun initPermissions() {
    }

    override fun onClick(v: View?) {
    }


    override fun getContext(): Context {
        return this
    }

    override fun getCountryCodesArray(): Array<String> {
        return resources.getStringArray(R.array.countryCodes)
    }

    override fun getTelephonyManager(): TelephonyManager {
        return getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    }

    override fun showDefaultCountryCode(code: String) {
    }

    override fun handleProgressAlert(showingStatus: Boolean) {
    }

    override fun fieldsValidationFailed(msg: String) {
        Toast.makeText(contex, msg, Toast.LENGTH_SHORT).show()
    }

    override fun goToNextPage() {
        Utils.hideKeyboard(this)
        val intent = Intent(contex, OTPActivity::class.java)
        startActivity(intent)
    }

    override fun isFragmentAlive(): Boolean {
        return false
    }

    override fun isActivityRunning(): Boolean {
        return true
    }

    override fun setPresenter(presenter: RegisterContract.Presenter) {
        signupPresenter = presenter as RegisterPresenter
        //signupPresenter.getDefaultCountryCode()
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

}
