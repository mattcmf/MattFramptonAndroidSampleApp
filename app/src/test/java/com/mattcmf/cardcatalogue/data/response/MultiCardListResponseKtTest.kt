package com.mattcmf.cardcatalogue.data.response

import com.mattcmf.cardcatalogue.data.Card
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MultiCardListResponseKtTest {

    @Before
    fun setUp() {
        clearAllMocks()
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
    }

    @Test
    fun `when I call toCardList against non null then a valid card is returned`() {
        assertEquals(MultiCardListResponse(listOf(basicCardListResponse)).toCardList(), basicCardList)
    }

    @Test
    fun `when I call toCardList against null then the default empty card is returned`() {
        assertEquals(
            MultiCardListResponse(listOf(CardListResponse.empty().copy())).toCardList(),
            listOf(Card.empty())
        )
    }

    @Test
    fun `when I call receive a cardlist with no monster cards then return empty`() {
        assertEquals(
            MultiCardListResponse(listOf(basicCardListResponse.copy(hp = null))).toCardList(),
            emptyList<CardListResponse>())
    }

    private val basicCardListResponse =
        CardListResponse.empty().copy(
            id = "123",
            name = "Bob",
            imageUrl = "someURL",
            hp = "103",
            attacks = listOf(
                Attack(
                    convertedEnergyCost = 123,
                    cost = listOf("cost123"),
                    damage = "50",
                    name = "Super blast",
                    text = "Instant win"
                )
            ),
            rarity = "Rare"
        )


    private val basicCardList = listOf(
        Card(
            id = "123",
            name = "Bob",
            imageURl = "someURL",
            hp = "103",
            attacks = listOf(
                Attack(
                    convertedEnergyCost = 123,
                    cost = listOf("cost123"),
                    damage = "50",
                    name = "Super blast",
                    text = "Instant win"
                )
            ),
            rarity = "Rare"
        )
    )
}