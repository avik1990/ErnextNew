package com.app.ernext.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.app.ernext.R
import com.app.ernext.fragments.home.Homefragment
import com.app.ernext.home.Dashboard
import com.app.ernext.others.Constants
import com.app.ernext.register.RegisterActivity

class SplashActivity : AppCompatActivity() {

    lateinit var handler: Handler
    val waitingTime: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_splash)
        waitscreen()
    }


    private fun waitscreen() {
        handler = Handler()
        handler.postDelayed(
                object : Runnable {
                    override fun run() {
                      /*  startActivity(Intent(this@SplashActivity, RegisterActivity::class.java))
                        finish()*/
                        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                        intent.putExtra(Constants.Keys.KEY_FRAGMENT_NAME, Homefragment.CLASS_NAME)
                        startActivity(intent)
                        finish()
                    }
                }, waitingTime)
    }
}
