package com.example.AnnushkaKotlinApp.data.Network

import com.example.meditation.data.Network.MeditationApIService
import com.example.AnnushkaKotlinApp.data.UserLogin


class MeditationApiServiceImpl(private val meditationApIService: MeditationApIService) {
    suspend fun login(userLogin: UserLogin) = meditationApIService.login(userLogin)
    suspend fun getQuote() = meditationApIService.getQuotes()
    suspend fun getFeeling() = meditationApIService.getFeelings()
}
