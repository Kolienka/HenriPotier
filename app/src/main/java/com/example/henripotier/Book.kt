package com.example.henripotier

data class Book(
    val isbn: String,
    val title: String,
    val price: Int,
    val synopsis: List<String>,
    val cover: String
)