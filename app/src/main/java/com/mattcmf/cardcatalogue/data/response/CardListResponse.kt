package com.mattcmf.cardcatalogue.data.response

data class CardListResponse(
    val ability: Ability?,
    val artist: String,
    val attacks: List<Attack>,
    val convertedRetreatCost: Int,
    val evolvesFrom: String,
    val hp: String?,
    val id: String,
    val imageUrl: String,
    val imageUrlHiRes: String,
    val name: String,
    val nationalPokedexNumber: Int,
    val number: String,
    val rarity: String,
    val resistances: List<Resistance>,
    val retreatCost: List<String>,
    val series: String,
    val `set`: String,
    val setCode: String,
    val subtype: String,
    val supertype: String,
    val text: List<String>,
    val types: List<String>,
    val weaknesses: List<Weaknesses>
) {
    companion object {
        fun empty(): CardListResponse {
            return CardListResponse(
                ability = null,
                artist = "",
                attacks = emptyList(),
                convertedRetreatCost = 0,
                evolvesFrom = "",
                hp = "",
                id = "",
                imageUrl = "",
                imageUrlHiRes = "",
                name = "",
                nationalPokedexNumber = 0,
                number = "",
                rarity = "",
                resistances = emptyList(),
                retreatCost = emptyList(),
                series = "",
                `set` = "",
                setCode = "",
                subtype = "",
                supertype = "",
                text = emptyList(),
                types = emptyList(),
                weaknesses = emptyList()
            )
        }
    }
}