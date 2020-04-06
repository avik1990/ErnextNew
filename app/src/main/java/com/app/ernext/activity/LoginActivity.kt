package com.app.ernext.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.app.ernext.R
import com.app.ernext.fragments.home.Homefragment
import com.app.ernext.home.Dashboard
import com.app.ernext.others.Constants
import com.app.ernext.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)
        context=this

        tv_skiplogin.setOnClickListener({
            val intent = Intent(context, Dashboard::class.java)
            intent.putExtra(Constants.Keys.KEY_FRAGMENT_NAME, Homefragment.CLASS_NAME)
            startActivity(intent)
            finishAffinity()
        })

        rl_signup.setOnClickListener {
            val i = Intent(context, RegisterActivity::class.java)
            startActivity(i)
        }
        tv_register.setOnClickListener {
            val i = Intent(context, RegisterActivity::class.java)
            startActivity(i)
        }
        tv_signup.setOnClickListener {
            val i = Intent(context, RegisterActivity::class.java)
            startActivity(i)
        }
    }

}
