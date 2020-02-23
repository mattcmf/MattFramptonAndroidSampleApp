package com.mattcmf.cardcatalogue.data

import com.mattcmf.cardcatalogue.data.response.toCardList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class CardListRepository(private val tradingCardAPIService: TradingCardAPIService) :
    ICardListRepository {

    //TODO: Add error handling and tests for scenarios.
    override suspend fun getCards(playerOneId: String, playerTwoId: String): List<Card>? {
        return withContext(Dispatchers.IO) {
            val cardData = async { tradingCardAPIService.requestCard(playerOneId) }
            val cardData2 = async { tradingCardAPIService.requestCard(playerTwoId) }
            listOf(cardData.await(), cardData2.await()).toCardList()
        }
    }

    override suspend fun getCardCollection(): List<Card>? {
        return withContext(Dispatchers.IO) {
            val setData = tradingCardAPIService.getCardsForSet("swsh1")
            setData.toCardList()
        }
    }
}