package com.matcmf.mattframpton_sampleapp.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CardListRepository(private val tradingCardAPIService: TradingCardAPIService) {
    fun getCards() {
        runBlocking {
            launch(Dispatchers.IO) {
                val cardData = async{ tradingCardAPIService.requestCard("swsh1-30")}
                val cardData2 = async {tradingCardAPIService.requestCard("swsh1-30") }
                val setData = tradingCardAPIService.getCardsForSet("swsh1")
                Log.d("test_debug", "${cardData.await()} ${setData.await()} ${cardData2.await()}")
            }
        }
    }
}