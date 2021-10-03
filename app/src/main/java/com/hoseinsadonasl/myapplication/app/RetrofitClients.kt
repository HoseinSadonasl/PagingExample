package com.hoseinsadonasl.myapplication.app

import com.hoseinsadonasl.myapplication.api.WorksApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private val BASE_URL = "https://api.crossref.org/"

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApi(): WorksApi {
        return retrofit.create(WorksApi::class.java)
    }
}