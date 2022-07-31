package com.example.retrofitinkotlin

data class Todo(
//    When data is much more, instead of writing everything manually, I have installed a plugin called JSON to Kotlin converter. Click on com.example.retrofitkotlin and there click on new -> kotlin data class file from JSON. There paste the json object
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)