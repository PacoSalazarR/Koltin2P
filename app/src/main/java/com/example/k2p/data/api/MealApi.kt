package com.example.k2p.data.api

import com.example.k2p.data.dto.CategoriesResponse
import com.example.k2p.data.dto.FoodsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("json/v1/1/categories.php")
    fun getAllCategories(): Call<CategoriesResponse>

    @GET("json/v1/1/filter.php")
    fun getFoodsByCategory(@Query("c") category: String): Call<FoodsResponse>
}