package com.example.newcryptoapp.data.network.model

import com.example.newcryptoapp.data.network.model.CoinNameContainerDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNamesListDto (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDto>? = null
)
