package com.example.mvvmexample.data.remote.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Serialiozwany obiekt z odpowiedzi z rest api (api zwraca dane w formacie json)
@JsonClass(generateAdapter = true)
data class CharactersResponse(
    @Json(name = "info")
    val info: Info?,
    @Json(name = "results")
    val results: List<Result>?
)
