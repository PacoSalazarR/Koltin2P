package com.example.k2p.core.di

import com.example.k2p.core.platform.NetworkHandler
import com.example.k2p.data.api.MealApi
import com.example.k2p.data.source.CategoryRepositoryImpl
import com.example.k2p.domain.repository.CategoryRepository
import com.example.k2p.framework.api.ApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //como va a funcionar: Esta clase solo se crea una vez
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCategoryRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): CategoryRepository = CategoryRepositoryImpl(apiProvider.getEndpoint(MealApi::class.java),networkHandler)
}