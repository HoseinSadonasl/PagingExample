package com.hoseinsadonasl.myapplication.objects

data class License(
    val URL: String,
    val content_version: String,
    val delay_in_days: Int,
    val start: Start
)