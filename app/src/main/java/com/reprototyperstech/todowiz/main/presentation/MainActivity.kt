package com.reprototyperstech.todowiz.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.reprototyperstech.todowiz.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(android.os.Build.VERSION.SDK_INT>30){
            val splashScreen: SplashScreen = installSplashScreen()
        }else{
            // normal splashscreen
        }

         //splashScreen.setKeepOnScreenCondition{true}
//        Thread.sleep(3000)
        initViewModel()
        setContentView(R.layout.activity_main)
    }
    fun initViewModel(){

    }
}