package com.example.mir_scoquiz.networking

import com.example.mir_scoquiz.models.QuestionQueryResult
import com.example.mir_scoquiz.models.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenDBApi {

    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
        @Query("type") type: String,
        @Query("difficulty") difficulty: String
    ): QuestionQueryResult

    companion object {
        const val BASE_URL = "https://opentdb.com/"
    }
}