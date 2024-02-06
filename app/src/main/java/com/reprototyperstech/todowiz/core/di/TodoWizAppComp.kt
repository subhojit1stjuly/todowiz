package com.reprototyperstech.todowiz.core.di

import com.reprototyperstech.todowiz.main.presentation.MainActivity
import dagger.Component

@Component
interface TodoWizAppComp {
    fun inject(mainActivity: MainActivity)
}