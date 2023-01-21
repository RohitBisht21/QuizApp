package com.example.mir_scoquiz.api

import com.google.gson.Gson
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit

object RetroFitHelper {
    private const val BASE_URL="https://opentdb.com/"

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}