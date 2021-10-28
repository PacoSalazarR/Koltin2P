package com.example.k2p.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.k2p.data.dao.FoodDao
import com.example.k2p.domain.model.Category
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.model.Like
import com.example.k2p.domain.model.User

//import com.amalip.cocktailapp.domain.model.User

/**
 * Created by Amalip on 10/5/2021.
 */

@Database(entities = [Food::class, Category::class, User::class, Like::class], version = 3)
abstract class FoodDb : RoomDatabase() {

    abstract fun foodDao(): FoodDao

}