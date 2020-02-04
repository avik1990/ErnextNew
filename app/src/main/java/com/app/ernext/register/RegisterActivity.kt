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
import com.app.ernext.others.Constants
import com.app.ernext.others.Utils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.rl_signup
import kotlinx.android.synthetic.main.activity_register.tv_register

class RegisterActivity : BaseActivity(), View.OnClickListener, RegisterContract.View {

    var contex: Context? = null
    lateinit var signupPresenter: RegisterPresenter
    var isPrivacyChecked: Boolean = false
    var isUserTypeChecked: Boolean = false
    var userType: String = ""

    override fun initResources() {
        RegisterPresenter(this, this).start()
        contex = this
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
            val i = Intent(contex, Dashboard::class.java)
            i.putExtra(Constants.Keys.KEY_FRAGMENT_NAME, Homefragment.CLASS_NAME)
            startActivity(i)
        }

        chk_box.setOnCheckedChangeListener { compoundButton, isChecked ->
            isPrivacyChecked = isChecked
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
        Toast.makeText(contex, "", Toast.LENGTH_SHORT).show()
    }
}
