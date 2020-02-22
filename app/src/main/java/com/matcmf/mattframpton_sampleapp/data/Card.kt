package com.matcmf.mattframpton_sampleapp.data

import com.matcmf.mattframpton_sampleapp.data.response.Attack

data class Card(
    val id: String,
    val name: String,
    val imageURl: String,
    val hp: String,
    val attacks: List<Attack>,
    val rarity: String
)