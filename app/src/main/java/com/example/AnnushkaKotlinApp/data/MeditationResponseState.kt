package com.example.AnnushkaKotlinApp.data

sealed class MeditationResponseState<T>(data: T? = null, exception: java.lang.Exception? = null){
    data class Success<T>(val data: T) : MeditationResponseState<T>(data = data)
    data class Error<T>(val exception: Exception) : MeditationResponseState<T>(exception = exception)
}