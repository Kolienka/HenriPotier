package com.example.henripotier

import com.example.henripotier.models.Book
import retrofit2.http.GET

interface Service {

    @GET("/books")
    suspend fun books(): List<Book>

}