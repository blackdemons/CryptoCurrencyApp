package com.vid.cryptocurrencyapp.domain.use_case.get_coins

import com.vid.cryptocurrencyapp.common.Resource
import com.vid.cryptocurrencyapp.data.remote.dto.toCoin
import com.vid.cryptocurrencyapp.domain.model.Coin
import com.vid.cryptocurrencyapp.domain.model.CoinDetail
import com.vid.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException){
            emit(Resource.Error<List<Coin>>("Coldn't reach server. Check your internet connection"))
        }
    }
}