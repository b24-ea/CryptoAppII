package com.aldanmaz.cryptoappii.presentation.coin_detail

import com.aldanmaz.cryptoappii.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)