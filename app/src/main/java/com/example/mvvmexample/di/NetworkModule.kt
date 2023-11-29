package com.example.mvvmexample.di

import com.example.mvvmexample.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    // Dodanie interceptora ktory odpowiada za wyświetlanie logów
    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    // Uworzenie obiektu OKHttpCLient (potrzebny dla retrofita)
    // + dodanie powyższego interceptora
    @Singleton
    @Provides
    fun provideOkHttpClient(
        okHttpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(okHttpLoggingInterceptor)
        .build()

    // Utworzenie obiektu retrofit wraz z:
    //  BASE_URL - url do rest API
    // Converter.Factory
    // OkHttpClient
    @Singleton
    @Provides
    fun provideRetrofit(
        converter: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(converter)
        .client(okHttpClient)
        .build()

    private companion object {
        // stała zmienna która ma link do rest api
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}
