package com.vid.cryptocurrencyapp.presentation.coin_detail

import com.vid.cryptocurrencyapp.domain.model.Coin
import com.vid.cryptocurrencyapp.domain.model.CoinDetail

class CoinLDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
) {
}