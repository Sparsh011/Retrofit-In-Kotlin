package com.example.retrofitinkotlin

import retrofit2.Response
import retrofit2.http.GET

// Here we define all the functions we need to access our API. In our case, that is just a single function to just fetch data from
interface TodoApiInterface {
    //    In the type of response, we are passing a List of Todo because we don't just want to fetch a single object.
    @GET("/todos") // Note - in @GET we write the suffix of the base URL from which we are fetching the data. http://jsonplaceholder.typicode.com/todos
//          this is base url                   | this is the url which we will pass in @GET
    suspend fun getTodos(): Response<List<Todo>> // Using the suspend keyword so that data is not fetched on the main thread and it is executed on coroutine

}