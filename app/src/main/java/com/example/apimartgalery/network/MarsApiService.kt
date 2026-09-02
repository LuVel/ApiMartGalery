package com.example.apimartgalery.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

//1. constant
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

//2. compiler retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//3. Request
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos() : String
}

//4. object retrofit
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}