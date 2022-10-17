package com.example.retrofitpractice.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface ShibeService {
    companion object{
        const val BASE_URL = "https://shibe.online/"
        const val END_POINT = "/api/shibes"
        const val count = "count"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val shibeService : ShibeService = retrofit.create()
    }

    @GET(END_POINT)
    suspend fun getShibe(@Query(count) _count : String) : Response<List<String>>
}