package com.example.mir_scoquiz.networking

import com.example.mir_scoquiz.models.QuestionQueryResult
import com.example.mir_scoquiz.models.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenDBApi {

    @GET("api.php")
     fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: String,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): QuestionQueryResult

    @GET("api.php")
    fun getQuestions(): Call<QuestionQueryResult>

    companion object {
        const val BASE_URL = "https://opentdb.com/"


    }
}