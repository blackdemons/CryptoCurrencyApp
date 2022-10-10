package com.vid.cryptocurrencyapp.domain.use_case.get_coin

import com.vid.cryptocurrencyapp.common.Resource
import com.vid.cryptocurrencyapp.data.remote.dto.toCoin
import com.vid.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.vid.cryptocurrencyapp.domain.model.Coin
import com.vid.cryptocurrencyapp.domain.model.CoinDetail
import com.vid.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException){
            emit(Resource.Error<CoinDetail>("Coldn't reach server. Check your internet connection"))
        }
    }
}