package com.example.mvvmexample.data.remote

import com.example.mvvmexample.data.remote.model.response.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface RemoteCharactersDataSource {

    @GET("character")
    suspend fun getRemoteCharacters(): Response<CharactersResponse>
}
