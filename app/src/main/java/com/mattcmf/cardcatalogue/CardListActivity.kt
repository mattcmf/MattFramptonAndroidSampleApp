package com.mattcmf.cardcatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_card_list.*
import org.koin.androidx.scope.currentScope

class CardListActivity : AppCompatActivity() {
    private val cardListViewModelFactory: CardListViewModelFactory by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)

        val viewModel = CardListViewModelProvider.get(this, cardListViewModelFactory)
        val cardListAdapter = CardListAdapter()
            .apply {
                viewModel.cardList.observe(this@CardListActivity, Observer { cardList ->
                    cards = cardList
                })
            }
        cardListRecycleView.adapter = cardListAdapter

        viewModel.loadCards()
    }
}
