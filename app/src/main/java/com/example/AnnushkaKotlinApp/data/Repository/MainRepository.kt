package com.example.AnnushkaKotlinApp.data.Repository

import com.example.AnnushkaKotlinApp.data.FeelingResponse
import com.example.AnnushkaKotlinApp.data.Network.MeditationApiServiceImpl
import com.example.AnnushkaKotlinApp.data.QuoteResponse
import com.example.AnnushkaKotlinApp.data.User
import com.example.AnnushkaKotlinApp.data.UserLogin
import com.example.AnnushkaKotlinApp.data.MeditationResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository(private val meditationApiServiceImpl: MeditationApiServiceImpl) {
    fun login(login: UserLogin): Flow<MeditationResponseState<User>> =
        flow {
//            return@flow try {
//                val user = meditationApiServiceImpl.login(login)
//                emit(MeditationResponseState.Success(data = user))
//            }
//            catch (e:Exception){
//                emit(MeditationResponseState.Error(exception = e))
//            }

        }
    fun getFeelings(): Flow<MeditationResponseState<FeelingResponse>> =
        flow {
            return@flow try {
                val feelingResponse = meditationApiServiceImpl.getFeeling()
                emit(MeditationResponseState.Success(data = feelingResponse))
            }
            catch (e:Exception){
                emit(MeditationResponseState.Error(exception = e))
            }

        }

    fun getQuotes(): Flow<MeditationResponseState<QuoteResponse>> =
        flow {
            return@flow try {
                val quoteResponse = meditationApiServiceImpl.getQuote()
                emit(MeditationResponseState.Success(data = quoteResponse))
            }
            catch (e:Exception){
                emit(MeditationResponseState.Error(exception = e))
            }
        }
}
