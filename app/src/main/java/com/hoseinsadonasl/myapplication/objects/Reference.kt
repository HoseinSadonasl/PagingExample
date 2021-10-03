package com.hoseinsadonasl.myapplication.objects

data class Reference(
    val DOI: String,
    val author: String,
    val doi_asserted_by: String,
    val first_page: String,
    val journal_title: String,
    val key: String,
    val series_title: String,
    val volume: String,
    val year: String
)