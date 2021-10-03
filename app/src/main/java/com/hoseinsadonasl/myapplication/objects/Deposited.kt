package com.hoseinsadonasl.myapplication.objects

data class Deposited(
    val date_parts: List<List<Int>>,
    val date_time: String,
    val timestamp: Long
)