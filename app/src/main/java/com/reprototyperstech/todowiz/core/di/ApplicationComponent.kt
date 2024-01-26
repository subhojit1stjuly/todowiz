package com.reprototyperstech.todowiz.core.di

import com.reprototyperstech.todowiz.main.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}
