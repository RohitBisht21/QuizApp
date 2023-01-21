package com.example.mir_scoquiz.networking

import com.example.mir_scoquiz.models.QuestionQueryResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenDBApi {

    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): QuestionQueryResult
    companion object {
        const val BASE_URL = "https://opentdb.com/"


    }
}