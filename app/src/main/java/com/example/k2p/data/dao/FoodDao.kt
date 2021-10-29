package com.example.k2p.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.k2p.domain.model.Category
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.model.Like
import com.example.k2p.domain.model.User

@Dao
interface FoodDao {

    //FOODS
    @Query("SELECT * FROM Food WHERE mealCategory LIKE :filter")
    fun getFoodsByCategory(filter: String): List<Food>

    @Query("SELECT * FROM Food WHERE mealName LIKE :filter")
    fun getFoodsByName(filter: String): List<Food>

    @Query("SELECT * FROM Food WHERE idMeal LIKE :filter")
    fun getFoodsById(filter: String): List<Food>

    @Query("SELECT * FROM Food ORDER BY RANDOM() LIMIT 1;")
    fun getRandomFood(): List<Food>

    @Insert(onConflict = REPLACE)
    fun saveFoods(foods: List<Food>): List<Long>

    //CATEGORIES
    @Query("SELECT * FROM Category")
    fun getAllCategories(): List<Category>

    @Insert(onConflict = REPLACE)
    fun saveCategories(categories: List<Category>): List<Long>

    //USERS
    @Query("SELECT * FROM User WHERE idUser LIKE :filter")
    fun getUserById(filter: String): User

    @Query("SELECT * FROM User WHERE userName LIKE :filter")
    fun getUserByName(filter: String): List<User>

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<User>): List<Long>

    //LIKES
    @Query("SELECT * FROM `Like` WHERE idLikeUser LIKE :filter")
    fun getUserLikes(filter: String): List<Like>

    @Query("SELECT * FROM `Like` WHERE idLikeFood LIKE :filter")
    fun getLikesByMealId(filter: String): List<Like>

    @Insert(onConflict = REPLACE)
    fun saveLike(likes: List<Like>): List<Long>

    @Query("DELETE FROM `Like` WHERE idLike LIKE :filter")
    fun deleteLike(filter: String): Int
}