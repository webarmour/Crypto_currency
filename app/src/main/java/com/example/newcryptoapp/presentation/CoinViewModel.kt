package com.example.newcryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.example.newcryptoapp.data.repository.CoinRepositoryImpl
import com.example.newcryptoapp.domain.GetCoinInfoListUseCase
import com.example.newcryptoapp.domain.GetCoinInfoUseCase
import com.example.newcryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {


    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}
