package com.sample

import android.app.Application
import com.sample.di.DI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DI.init(this)
    }
}
