package com.example.apimartgalery.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.getValue

//1. constant
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"


data class MarsPhoto(
    val id: String,
    val img_src: String
)

//2. compiler retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//3. Request
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

//4. object retrofit
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}