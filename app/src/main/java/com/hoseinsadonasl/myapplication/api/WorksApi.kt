package com.hoseinsadonasl.myapplication.api

import com.hoseinsadonasl.myapplication.objects.Message
import com.hoseinsadonasl.myapplication.objects.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WorksApi {

    @GET("works")
    fun getWorks(
        @Query("offset") offset: Int,
        @Query("rows") rows: Int,
    ): Call<Response>

}