package com.example.uas_mobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://thronesapi.com/"
private const val BASE_URL2 = "https://www.breakingbadapi.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DisneyApiService {
    @GET("/api/v2/Characters")
    suspend fun getPhotos(): List<DisneyPhoto>
}

object DisneyApi {
    val retrofitService : DisneyApiService by lazy {
        retrofit.create(DisneyApiService::class.java) }
}

// =======================================

private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface DisneyApiService2 {
    @GET("/api/characters")
    suspend fun getPhotos(): List<BreakingBadPhoto>
}

object DisneyApi2 {
    val retrofitService : DisneyApiService2 by lazy {
        retrofit.create(DisneyApiService2::class.java) }
}