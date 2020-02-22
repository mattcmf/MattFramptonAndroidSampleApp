package com.matcmf.mattframpton_sampleapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matcmf.mattframpton_sampleapp.data.response.toCardList
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class CardListRepository(private val tradingCardAPIService: TradingCardAPIService) {

    private var _currentCardList = MutableLiveData<List<Card>>()
    val data: LiveData<List<Card>>
        get() = _currentCardList

    fun getCards() {
        runBlocking {
            launch(IO) {
                val cardData = async { tradingCardAPIService.requestCard("swsh1-30") }
                val cardData2 = async { tradingCardAPIService.requestCard("swsh1-30") }
                Log.d("test_debug", "${cardData.await()} ${cardData2.await()}")
            }
        }
    }

    fun getCardCollection() {
        runBlocking {
            withContext(IO) {
                val setData = tradingCardAPIService.getCardsForSet("swsh1")
                val response = setData.await().toCardList()
                _currentCardList.postValue(response)
                Log.d("test_debug", response.toString())
            }
        }
    }
}


