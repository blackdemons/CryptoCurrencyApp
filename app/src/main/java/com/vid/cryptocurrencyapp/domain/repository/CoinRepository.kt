package com.vid.cryptocurrencyapp.domain.repository

import com.vid.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.vid.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}