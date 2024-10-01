package com.example.newcryptoapp.di

import android.app.Application
import com.example.newcryptoapp.data.database.AppDatabase
import com.example.newcryptoapp.data.database.CoinInfoDao
import com.example.newcryptoapp.data.repository.CoinRepositoryImpl
import com.example.newcryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {


    @Binds
    fun bindCoinRepository(coinRepositoryImpl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        fun provideCoinInfoDao(application: Application):CoinInfoDao{
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }



}