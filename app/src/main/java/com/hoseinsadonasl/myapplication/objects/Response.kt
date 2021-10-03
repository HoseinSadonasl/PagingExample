package com.hoseinsadonasl.myapplication.objects

data class Response(
    val message: Message,
    val message_type: String,
    val message_version: String,
    val status: String
)