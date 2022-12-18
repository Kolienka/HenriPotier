package com.example.henripotier

import retrofit2.http.GET

interface Service {

    @GET("/books")
    suspend fun books(): List<Book>

}