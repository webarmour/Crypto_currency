package com.example.newcryptoapp

import android.app.Application
import com.example.newcryptoapp.di.DaggerApplicationComponent
import dagger.internal.DaggerCollections

class CoinApp: Application() {

        val component by lazy {
                DaggerApplicationComponent.factory().create(this)
        }
}