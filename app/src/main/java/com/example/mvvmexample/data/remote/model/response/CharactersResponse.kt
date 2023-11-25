package com.example.mvvmexample.data.remote.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersResponse(
    @Json(name = "info")
    val info: Info?,
    @Json(name = "results")
    val results: List<Result>?
)
