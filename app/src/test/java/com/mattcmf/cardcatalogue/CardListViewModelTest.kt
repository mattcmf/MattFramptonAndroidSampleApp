package com.mattcmf.cardcatalogue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mattcmf.cardcatalogue.CardListViewModel.Companion.PLAYER_ONE_DEFAULT
import com.mattcmf.cardcatalogue.CardListViewModel.Companion.PLAYER_TWO_DEFAULT
import com.mattcmf.cardcatalogue.data.*
import com.mattcmf.cardcatalogue.data.response.CardListResponse
import com.mattcmf.cardcatalogue.data.response.MultiCardListResponse
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CardListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var cardListRepository: ICardListRepository

    @Before
    fun setUp() {
        clearAllMocks()
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
    }

    @Test
    fun `when I call load all cards then cardList is updated with non specific list of cards`() {
        coEvery { cardListRepository.getCardCollection() } returns listOf(
            Card.empty().copy(id = "custom_card_123")
        )

        val sut = CardListViewModel(cardListRepository)
        sut.loadAllCards()

        assertEquals(
            listOf(Card.empty().copy(id = "custom_card_123")),
            sut.data.getOrAwaitValue()
        )
    }

    @Test
    fun `when I call loadDefaultCards then the default cards are loaded`() {
        coEvery { cardListRepository.getCards(PLAYER_ONE_DEFAULT,PLAYER_TWO_DEFAULT ) } returns
                listOf(
                    Card.empty().copy(id = PLAYER_ONE_DEFAULT),
                    Card.empty().copy(id = PLAYER_TWO_DEFAULT)
                )

        val sut = CardListViewModel(cardListRepository)
        sut.loadDefaultCards()

        assertEquals(
            listOf(
                Card.empty().copy(id = PLAYER_ONE_DEFAULT),
                Card.empty().copy(id = PLAYER_TWO_DEFAULT)
            ),
            sut.data.getOrAwaitValue()

        )
    }
}