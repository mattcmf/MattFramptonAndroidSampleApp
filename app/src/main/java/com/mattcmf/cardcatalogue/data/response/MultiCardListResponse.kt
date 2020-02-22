package com.mattcmf.cardcatalogue.data.response

import com.mattcmf.cardcatalogue.data.Card

data class MultiCardListResponse(
    val cards: List<CardListResponse>
)

fun MultiCardListResponse.toCardList(): List<Card>? {
    return this.cards.map{
        Card(it.name, it.name, it.imageUrl, "${it.hp} hp", it.attacks ?: listOf(Attack()), it.rarity)
    }
}