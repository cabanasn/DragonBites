package com.nc.dragonbites.data.repository

import com.nc.dragonbites.data.remote.response.Recipe
import com.nc.dragonbites.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeListRepository {
    suspend fun getRecipes(): Flow<Resource<List<Recipe>>>
}