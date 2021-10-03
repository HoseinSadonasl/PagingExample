package com.hoseinsadonasl.myapplication.objects

data class Indexed(
    val date_parts: List<List<Int>>,
    val date_time: String,
    val timestamp: Long
)