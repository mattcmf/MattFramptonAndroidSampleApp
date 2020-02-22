package com.matcmf.mattframpton_sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.scope.currentScope

class CardListActivity : AppCompatActivity() {

    private val cardListViewModelFactory: CardListViewModelFactory by currentScope.inject()
    private lateinit var viewModel: CardListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)

        viewModel = CardListViewModelProvider.get(this, cardListViewModelFactory)
        viewModel.loadCards()
    }
}
