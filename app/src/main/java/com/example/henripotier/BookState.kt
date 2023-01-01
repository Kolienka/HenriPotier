package com.example.henripotier

import com.example.henripotier.models.Book

data class BookState(
    val books: List<Book> = emptyList(),
    val isLoading: Boolean
)