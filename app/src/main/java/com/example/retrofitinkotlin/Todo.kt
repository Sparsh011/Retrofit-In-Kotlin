package com.example.retrofitinkotlin

data class Todo(
//    When data is much more, instead of writing everything manually, click on com.example.retrofitkotlin and there click on new -> kotlin data class file from JSON. There paste the json object copied from documentation
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)