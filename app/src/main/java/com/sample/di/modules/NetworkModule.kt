package com.sample.di.modules

import com.google.gson.GsonBuilder
import com.sample.data.local.ApiConstants
import com.sample.data.network.CommonService
import com.sample.data.network.UserService
import com.sample.di.modules.Constants.API_KEY
import com.sample.di.modules.Constants.CONNECTION_TIMEOUT
import com.sample.di.modules.Constants.Q_NASA_RETROFIT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//==============================================================================================
// *** Network ***
//==============================================================================================
private object Constants {

    const val CONNECTION_TIMEOUT = 30L
    const val NASA_RETROFIT = "nasa_retrofit"
    const val API_KEY = "api_key"
    // Qualifier field
    val Q_NASA_RETROFIT = named(NASA_RETROFIT)
}

val networkModule = module {

    single { get<Retrofit>().create(UserService::class.java) }
    single { get<Retrofit>(Q_NASA_RETROFIT).create(CommonService::class.java) }

    single { GsonBuilder().create() }

    single {
        OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            )
        }
    }

    single {
        val okHttpClient = get<OkHttpClient.Builder>().build()

        val build = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_SERVER_URL_USERS)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    get()
                )
            )
            .build()

        build
    }

    single(Q_NASA_RETROFIT) {

        val okHttpClientBuilder = get<OkHttpClient.Builder>()

        val okHttpClient = okHttpClientBuilder.apply {
            addInterceptor { chain ->
                val original = chain.request()

                val originalHttpUrl = original.url

                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter(API_KEY, ApiConstants.Keys.NASA_API_KEY)
                    .build()
                val requestBuilder = original.newBuilder()
                    .url(url)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
        }.build()

        val build = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_SERVER_URL_NASA)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    get()
                )
            )
            .build()

        build
    }


}