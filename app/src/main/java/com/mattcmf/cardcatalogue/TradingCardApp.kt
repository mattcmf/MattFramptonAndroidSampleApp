package com.mattcmf.cardcatalogue


import android.annotation.SuppressLint
import android.app.Application
import com.mattcmf.cardcatalogue.di.cardListModule
import com.mattcmf.cardcatalogue.di.networkModule
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

@SuppressLint("Registered")
open class TradingCardApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    open fun initDI() {
        startKoin {

            androidContext(this@TradingCardApp)

            modules(listOf(
                networkModule,
                cardListModule
            ))
        }
    }
}
