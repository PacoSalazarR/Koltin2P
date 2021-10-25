package com.example.k2p.core.di

import android.content.Context
import androidx.room.Room
import com.example.k2p.framework.db.FoodDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Amalip on 10/5/2021.
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCocktailDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodDb::class.java, "foods").addMigrations(
        ).build()
}