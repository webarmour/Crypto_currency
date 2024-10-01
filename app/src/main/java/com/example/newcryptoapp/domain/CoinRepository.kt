package com.example.newcryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.newcryptoapp.domain.CoinInfo

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}
