package com.example.newcryptoapp.di

import androidx.lifecycle.ViewModel
import com.example.newcryptoapp.presentation.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindsCoinViewModel(viewModel: CoinViewModel): ViewModel
}