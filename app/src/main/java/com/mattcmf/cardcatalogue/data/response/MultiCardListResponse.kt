package com.mattcmf.cardcatalogue.data.response

import com.mattcmf.cardcatalogue.data.Card

data class MultiCardListResponse(
    val cards: List<CardListResponse>
)

fun MultiCardListResponse.toCardList(): List<Card>? {
    return this.cards.toCardList()
}

fun List<CardListResponse>.toCardList(): List<Card>? {
    return this
        .filter { it.hp != null }
        .map {
        Card(
            it.id,
            it.name,
            it.imageUrl,
            it.hp,
            it.attacks,
            it.rarity
        )
    }
}