package com.example.myapplication

import com.example.myapplication.rest.RetrofitHelper


class Datasource {
    suspend fun loadNews(): Response {
        return RetrofitHelper.getInstance().create(ApiService::class.java).getPosts()
    }
}
