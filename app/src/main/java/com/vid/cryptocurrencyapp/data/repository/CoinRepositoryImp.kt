package com.vid.cryptocurrencyapp.data.repository

import com.vid.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.vid.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.vid.cryptocurrencyapp.data.remote.dto.CoinDto
import com.vid.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}