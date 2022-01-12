package com.aldanmaz.cryptoappii.domain.use_case.get_coin

import com.aldanmaz.cryptoappii.common.Resource
import com.aldanmaz.cryptoappii.data.remote.dto.toCoin
import com.aldanmaz.cryptoappii.data.remote.dto.toCoinDetail
import com.aldanmaz.cryptoappii.domain.model.Coin
import com.aldanmaz.cryptoappii.domain.model.CoinDetail
import com.aldanmaz.cryptoappii.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
           emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}