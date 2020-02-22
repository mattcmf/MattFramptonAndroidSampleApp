package com.mattcmf.cardcatalogue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mattcmf.cardcatalogue.data.CardListRepository

class CardListViewModel(private val cardListRepository: CardListRepository) : ViewModel() {

    val cardList = cardListRepository.data

    fun loadCards() {
        cardListRepository.getCards()
        cardListRepository.getCardCollection()
    }
}

class CardListViewModelFactory(private val cardListRepository: CardListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CardListViewModel(cardListRepository) as T
    }
}

object CardListViewModelProvider {
    fun get(owner: ViewModelStoreOwner, viewModelProvider: ViewModelProvider.Factory):
            CardListViewModel = ViewModelProvider(owner, viewModelProvider)
        .get(CardListViewModel::class.java)
}