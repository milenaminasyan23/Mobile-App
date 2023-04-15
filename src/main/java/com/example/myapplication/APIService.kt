package com.example.myapplication

import retrofit2.http.GET

interface ApiService {
    @GET("entries")
    suspend fun getPosts(): Response ///
}