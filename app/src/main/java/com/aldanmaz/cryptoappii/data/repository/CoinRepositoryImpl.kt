package com.aldanmaz.cryptoappii.data.repository

import com.aldanmaz.cryptoappii.data.remote.CoinPaprikaApi
import com.aldanmaz.cryptoappii.data.remote.dto.CoinDetailDto
import com.aldanmaz.cryptoappii.data.remote.dto.CoinDto
import com.aldanmaz.cryptoappii.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}