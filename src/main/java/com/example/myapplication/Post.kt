package com.example.myapplication

data class User(
    val API: String,
    val Description: String,
    val Auth: String,
    val HTTPS: Boolean,
    val Cors: Boolean,
    val Link: String,
    val Category: String,
)
data class Response(
    val count: Int,
    val entries: List<User>
)