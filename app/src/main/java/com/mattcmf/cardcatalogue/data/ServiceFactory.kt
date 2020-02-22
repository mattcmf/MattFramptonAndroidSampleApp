package com.mattcmf.cardcatalogue.data

import retrofit2.Retrofit

class ServiceFactory(retrofit: Retrofit){
    val tradingCardAPIService: TradingCardAPIService by lazy { retrofit.create(TradingCardAPIService::class.java) }
}