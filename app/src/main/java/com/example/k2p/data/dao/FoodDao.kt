package com.example.k2p.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.k2p.domain.model.Category
import com.example.k2p.domain.model.Food

@Dao
interface FoodDao {

    @Query("SELECT * FROM Category")
    fun getAllCategories(): List<Category>

    @Query("SELECT * FROM Food WHERE mealCategory LIKE :filter")
    fun getFoodsByCategory(filter: String): List<Food>

    @Insert(onConflict = REPLACE)
    fun saveCategories(categories: List<Category>): List<Long>

    @Insert(onConflict = REPLACE)
    fun saveFoods(foods: List<Food>): List<Long>

}