package com.matcmf.mattframpton_sampleapp.data

import com.matcmf.mattframpton_sampleapp.data.response.CardListResponse
import com.matcmf.mattframpton_sampleapp.data.response.MultiCardListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TradingCardAPIService {

    /*
    https://pokemontcg.io/cards?setCode=swsh1
    */
    @GET("cards/")
    fun getCardsForSet(@Query("setCode") code: String): Deferred<MultiCardListResponse>

    @GET("cards/{id}")
    fun requestCard(@Path("id") id: String): Deferred<CardListResponse>
}