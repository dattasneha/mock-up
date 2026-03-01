package com.snehadatta.mockup

import android.app.Application
import com.snehadatta.mockup.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MockupApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MockupApplication)
            modules(sharedModule)
        }
    }
}