package com.matcmf.mattframpton_sampleapp.data.response

import com.matcmf.mattframpton_sampleapp.data.Card

data class MultiCardListResponse(
    val cards: List<CardListResponse>
)

fun MultiCardListResponse.toCardList(): List<Card>? {
    return this.cards.map{
        Card(it.name, it.name)
    }
}