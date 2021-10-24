package com.amalip.cocktailapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amalip.cocktailapp.data.dao.CocktailDao
import com.amalip.cocktailapp.domain.model.Cocktail
//import com.amalip.cocktailapp.domain.model.User

/**
 * Created by Amalip on 10/5/2021.
 */

@Database(entities = [Cocktail::class/*, User::class*/], version = 4)
abstract class CocktailDb : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao

}