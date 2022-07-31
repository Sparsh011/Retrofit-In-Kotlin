package com.example.retrofitinkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: TodoApiInterface by lazy {
        Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(TodoApiInterface::class.java)
    }
}