package com.hoseinsadonasl.myapplication.objects

data class Item(
    val DOI: String,
    val ISSN: List<String>,
    val URL: String,
    val alternative_id: List<String>,
    val author: List<Author>,
    val container_title: List<String>,
    val content_domain: ContentDomain,
    val created: Created,
    val deposited: Deposited,
    val indexed: Indexed,
    val is_referenced_by_count: Int,
    val issn_type: List<IssnType>,
    val issue: String,
    val issued: Issued,
    val journal_issue: JournalIssue,
    val language: String,
    val license: List<License>,
    val link: List<Link>,
    val member: String,
    val page: String,
    val prefix: String,
    val published: Published,
    val published_print: PublishedPrintX,
    val publisher: String,
    val reference: List<Reference>,
    val reference_count: Int,
    val references_count: Int,
    val score: Double,
    val short_container_title: List<String>,
    val source: String,
    val subject: List<String>,
    val title: List<String>,
    val type: String,
    val volume: String
)