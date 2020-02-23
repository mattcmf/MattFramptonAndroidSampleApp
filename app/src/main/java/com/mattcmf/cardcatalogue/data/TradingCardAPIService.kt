package com.mattcmf.cardcatalogue.data

import com.mattcmf.cardcatalogue.data.response.CardListResponse
import com.mattcmf.cardcatalogue.data.response.MultiCardListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TradingCardAPIService {

    /*
    https://pokemontcg.io/cards?setCode=swsh1
    */
    @GET("cards/")
    suspend fun getCardsForSet(@Query("setCode") code: String): MultiCardListResponse

    @GET("cards/{id}")
    fun requestCard(@Path("id") id: String): CardListResponse
}