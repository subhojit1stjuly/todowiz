package com.reprototyperstech.todowiz.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.reprototyperstech.todowiz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen: SplashScreen = installSplashScreen()
         //splashScreen.setKeepOnScreenCondition{true}
        Thread.sleep(3000)
        setContentView(R.layout.activity_main)
    }
}