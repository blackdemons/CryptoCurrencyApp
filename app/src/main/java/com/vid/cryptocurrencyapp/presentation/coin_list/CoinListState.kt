package com.vid.cryptocurrencyapp.presentation.coin_list

import com.vid.cryptocurrencyapp.domain.model.Coin

class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
) {
}