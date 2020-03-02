package com.sample.di

import android.app.Application
import com.google.gson.GsonBuilder
import com.sample.data.local.ApiConstants
import com.sample.data.network.UserService
import com.sample.di.modules.networkModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit

object DI {

    fun init(app: Application) {
        val allModules: List<Module> = listOf(
            networkModule,
            navigationModule,
            appModule
        )

        startKoin {
            AndroidLogger()
            androidContext(app)
            modules(allModules)
        }
    }
}

//==============================================================================================
// *** Features ***
//==============================================================================================

val appModule = module {

}

//==============================================================================================
// *** Navigation ***
//==============================================================================================

val navigationModule = module {
    single { Cicerone.create<Router>(Router()) }
    single<Router> { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }
}
