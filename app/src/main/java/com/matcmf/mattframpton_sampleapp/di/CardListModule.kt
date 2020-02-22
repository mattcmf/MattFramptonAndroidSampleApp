package com.matcmf.mattframpton_sampleapp.di

import com.matcmf.mattframpton_sampleapp.CardListActivity
import com.matcmf.mattframpton_sampleapp.CardListViewModelFactory
import com.matcmf.mattframpton_sampleapp.data.CardListRepository
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