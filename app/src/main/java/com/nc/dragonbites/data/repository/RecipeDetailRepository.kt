package com.nc.dragonbites.data.repository

import com.nc.dragonbites.domain.model.RecipeDetail
import com.nc.dragonbites.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeDetailRepository {
    suspend fun getRecipeDetail(id: String): Flow<Resource<RecipeDetail>>
}