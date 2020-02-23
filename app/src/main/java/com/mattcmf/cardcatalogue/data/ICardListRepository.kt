package com.mattcmf.cardcatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mattcmf.cardcatalogue.data.response.CardListResponse

interface ICardListRepository {
    suspend fun getCards(playerOneId: String, playerTwoId: String): List<Card>?
    suspend fun getCardCollection(): List<Card>?
}