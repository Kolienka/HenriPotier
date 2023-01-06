package com.example.henripotier

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton{
    private var retrofit: Retrofit? = null
    private const val BASE_URL : String = "https://henri-potier.techx.fr"

    val getInstance: Retrofit
        get(){
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}