package com.example.meditation.data.Network

import com.example.AnnushkaKotlinApp.data.FeelingResponse
import com.example.AnnushkaKotlinApp.data.QuoteResponse
import com.example.AnnushkaKotlinApp.data.User
import com.example.AnnushkaKotlinApp.data.UserLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MeditationApIService {
    @POST("user/login")
    suspend fun login(@Body login: UserLogin): Response<User>

    @GET("quotes")
    suspend fun getQuotes():QuoteResponse

    @GET("feelings")
    suspend fun getFeelings():FeelingResponse
}