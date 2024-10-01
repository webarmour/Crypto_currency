package com.example.newcryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.newcryptoapp.data.database.AppDatabase
import com.example.newcryptoapp.data.database.CoinInfoDao
import com.example.newcryptoapp.data.mapper.CoinMapper
import com.example.newcryptoapp.data.network.ApiFactory
import com.example.newcryptoapp.data.workers.RefreshDataWorker
import com.example.newcryptoapp.domain.CoinInfo
import com.example.newcryptoapp.domain.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val application: Application,
    private val mapper : CoinMapper,
    private val coinInfoDao: CoinInfoDao
) : CoinRepository {


    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getPriceList().map {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }


    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()

        )
    }
}
