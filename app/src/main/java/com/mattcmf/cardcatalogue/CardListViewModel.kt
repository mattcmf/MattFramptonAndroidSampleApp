package com.mattcmf.cardcatalogue

import androidx.lifecycle.*
import com.mattcmf.cardcatalogue.data.Card
import com.mattcmf.cardcatalogue.data.CardListRepository
import com.mattcmf.cardcatalogue.data.ICardListRepository
import kotlinx.coroutines.*

class CardListViewModel(private val cardListRepository: ICardListRepository) : ViewModel() {

    private var _currentCardList = MutableLiveData<List<Card>>()
    val data: LiveData<List<Card>>
        get() = _currentCardList

    fun loadAllCards() {
        viewModelScope.launch {
            val cardList = cardListRepository.getCardCollection()
            _currentCardList.postValue(cardList)
        }
    }

    fun loadDefaultCards() {
        viewModelScope.launch {
            val cardList = cardListRepository.getCards(PLAYER_ONE_DEFAULT, PLAYER_TWO_DEFAULT)
            _currentCardList.postValue(cardList)
        }
    }

    companion object {
        const val PLAYER_ONE_DEFAULT = "starter_card_one"
        const val PLAYER_TWO_DEFAULT = "starter_card_two"
    }
}

@Suppress("UNCHECKED_CAST")
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