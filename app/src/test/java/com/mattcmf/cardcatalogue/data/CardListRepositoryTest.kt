package com.mattcmf.cardcatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mattcmf.cardcatalogue.CardListViewModel
import com.mattcmf.cardcatalogue.data.response.CardListResponse
import com.mattcmf.cardcatalogue.data.response.MultiCardListResponse
import com.mattcmf.cardcatalogue.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CardListRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var tradingCardAPIService: TradingCardAPIService

    @Before
    fun setUp() {
        clearAllMocks()
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
    }

    @Test
    fun `when I call getCards then a list of two cards is returned`() = runBlocking {
        coEvery { tradingCardAPIService.requestCard("card1") } returns CardListResponse.empty()
            .copy(id = "test1")
        coEvery { tradingCardAPIService.requestCard("card2") } returns CardListResponse.empty()
            .copy(id = "test2")

        val sut = CardListRepository(tradingCardAPIService)
        val actual = sut.getCards("card1", "card2")

        assertEquals(
            listOf(
                Card.empty().copy(id = "test1"),
                Card.empty().copy(id = "test2")
            ),
            actual
        )
    }

    @Test
    fun `when I call getCardCollection then the full set of x cards is returned`() = runBlocking {
        coEvery { tradingCardAPIService.getCardsForSet("swsh1") } returns MultiCardListResponse(
            listOf(CardListResponse.empty().copy(id = "123"))
        )

        val sut = CardListRepository(tradingCardAPIService)
        val actual = sut.getCardCollection()

        assertEquals(
            listOf(Card.empty().copy(id = "123")), actual
        )
    }
}
