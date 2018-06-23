package com.edu

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

/**
 * Created by Sai on 6/19/2018.
 */

class FlashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_flash)


        Handler().postDelayed(/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

        {
            // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@FlashActivity, LoginActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())


    }

    companion object {

        private val SPLASH_TIME_OUT = 2000
    }

}