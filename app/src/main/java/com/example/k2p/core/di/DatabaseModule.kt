package com.example.k2p.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.k2p.framework.db.FoodDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private val MIGRATION_1_2 = object : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("DROP TABLE User;")
            database.execSQL("CREATE TABLE IF NOT EXISTS User(idUser INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, userName TEXT NOT NULL, password TEXT NOT NULL)")
        }
    }

    private val MIGRATION_2_3 = object : Migration(2,3){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Like`(idLike INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, idLikeFood INTEGER NOT NULL, idLikeUser INTEGER NOT NULL)")
        }
    }

    @Provides
    @Singleton
    fun provideCocktailDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodDb::class.java, "foods").addMigrations(
            MIGRATION_1_2, MIGRATION_2_3
        ).build()
}