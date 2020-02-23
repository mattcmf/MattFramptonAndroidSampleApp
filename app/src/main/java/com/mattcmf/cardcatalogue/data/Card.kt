package com.mattcmf.cardcatalogue.data

import com.mattcmf.cardcatalogue.data.response.Attack

data class Card(
    val id: String,
    val name: String,
    val imageURl: String,
    val hp: String,
    val attacks: List<Attack>,
    val rarity: String
) {
    companion object {
        fun empty(): Card = Card(
            id = "",
            name = "",
            imageURl = "",
            hp = "",
            attacks = emptyList(),
            rarity = ""
        )
    }
}