package com.hoseinsadonasl.myapplication.objects

data class Message(
    val facets: Facets,
    val items: List<Item>,
    val items_per_page: Int,
    val query: Query,
    val total_results: Int
)