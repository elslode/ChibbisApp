package com.elslode.chibbistestapp

import android.app.Application
import com.elslode.chibbistestapp.di.DaggerApplicationComponent

class AppChibbis: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}