package com.aldanmaz.cryptoappii.domain.repository

import com.aldanmaz.cryptoappii.data.remote.dto.CoinDetailDto
import com.aldanmaz.cryptoappii.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}