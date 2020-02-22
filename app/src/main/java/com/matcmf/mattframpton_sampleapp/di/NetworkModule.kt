package com.matcmf.mattframpton_sampleapp.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.matcmf.mattframpton_sampleapp.data.ServiceFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    single {
        GsonBuilder()
            .setLenient().serializeNulls().create()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.pokemontcg.io/v1/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single {
        ServiceFactory(get()).tradingCardAPIService
    }
}