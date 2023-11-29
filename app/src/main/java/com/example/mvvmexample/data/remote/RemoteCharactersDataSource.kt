package com.example.mvvmexample.data.remote

import com.example.mvvmexample.data.remote.model.response.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

// Interfejs data source'a
interface RemoteCharactersDataSource {

    // metoda pobiera liste postaci z API
    // request GET
    @GET("character")
    suspend fun getRemoteCharacters(): Response<CharactersResponse>
}
