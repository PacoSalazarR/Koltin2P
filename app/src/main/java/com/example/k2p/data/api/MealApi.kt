package com.example.k2p.data.api

import com.example.k2p.data.dto.CategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {
    @GET("json/v1/1/categories.php")
    fun getAllCategories(): Call<CategoriesResponse>
}