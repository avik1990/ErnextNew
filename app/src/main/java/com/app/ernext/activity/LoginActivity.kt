package com.app.ernext.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.app.ernext.R
import com.app.ernext.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)
        context=this


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
