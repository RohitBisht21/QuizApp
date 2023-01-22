package com.example.mir_scoquiz.models


import com.squareup.moshi.Json

data class QuestionQueryResult(
    @Json(name = "response_code")
    val responseCode: Int,
    val results: List<Result>
) {

}