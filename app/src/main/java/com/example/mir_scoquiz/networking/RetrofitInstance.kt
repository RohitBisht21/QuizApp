package com.example.mir_scoquiz.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
   private val retrofit by lazy{
      Retrofit.Builder()
         .baseUrl("https://opentdb.com/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()
   }
   val apiInterface by lazy {
      retrofit.create(OpenDBApi::class.java)
   }
}