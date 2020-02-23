package com.mattcmf.cardcatalogue.di

import com.mattcmf.cardcatalogue.CardListActivity
import com.mattcmf.cardcatalogue.CardListViewModelFactory
import com.mattcmf.cardcatalogue.data.CardListRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val cardListModule = module {
    scope(named<CardListActivity>()) {
        scoped{
            CardListRepository(get())
        }
        scoped{
            CardListViewModelFactory(get())
        }
    }
}