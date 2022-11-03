package com.example.retrofitinkotlin

import retrofit2.Response
import retrofit2.http.GET

// Here we define what data we need from the API.
interface TodoApiInterface {
    //    In the type of response, we are passing a List of Todo because we don't just want to fetch a single todo.
    @GET("/todos") // Note - in @GET we write the suffix of the base URL from which we are fetching the data. http://jsonplaceholder.typicode.com/todos
//          this is base url                   | this is the url which we will pass in @GET
    suspend fun getTodos(): Response<List<Todo>> // Using the suspend keyword so that data is not fetched on the main thread and it is executed on coroutine

}