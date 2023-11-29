package com.example.mvvmexample.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    // Utworzenie obiektu moshi do serializacji danych
    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // A tutaj utworzenie Converter.Factory (potrzebny do retrofita)
    @Provides
    @Singleton
    fun provideMoshiConverterFactory(
        moshi: Moshi
    ): Converter.Factory = MoshiConverterFactory.create(moshi)
}
