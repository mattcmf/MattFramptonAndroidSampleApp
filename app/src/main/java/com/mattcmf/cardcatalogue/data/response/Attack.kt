package com.mattcmf.cardcatalogue.data.response

data class Attack(
    val convertedEnergyCost: Int? = null,
    val cost: List<String>? = null,
    val damage: String = "-",
    val name: String = "-",
    val text: String = "-"
)