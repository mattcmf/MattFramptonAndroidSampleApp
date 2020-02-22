package com.mattcmf.cardcatalogue.data

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class CardListRepositoryTest {

    @MockK
    lateinit var tradingCardAPIService: TradingCardAPIService

    @Before
    fun setUp() {
        clearAllMocks()
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
    }

    @Test
    fun `when I call getData with a valid card then I have a card available`() {
        val sut = CardListRepository(tradingCardAPIService)
        sut.getCards()

    }

    @Test
    fun getCards() {
    }

    @Test
    fun getCardCollection() {
    }
}