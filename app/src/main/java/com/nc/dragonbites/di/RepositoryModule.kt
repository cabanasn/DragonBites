package com.nc.dragonbites.di

import com.nc.dragonbites.data.repository.RecipeDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.nc.dragonbites.data.repository.RecipeListRepositoryImpl
import com.nc.dragonbites.data.repository.RecipeDetailRepositoryImpl
import com.nc.dragonbites.data.repository.RecipeListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRecipeListRepository(recipeListRepositoryImpl: RecipeListRepositoryImpl): RecipeListRepository

    @Binds
    @Singleton
    abstract fun bindRecipeDetailRepository(recipeDetailRepositoryImpl: RecipeDetailRepositoryImpl): RecipeDetailRepository

}