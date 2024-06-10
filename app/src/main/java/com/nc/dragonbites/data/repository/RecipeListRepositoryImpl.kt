package com.nc.dragonbites.data.repository

import com.nc.dragonbites.data.local.RecipesDatabase
import com.nc.dragonbites.data.mappers.asDomain
import com.nc.dragonbites.data.mappers.asEntity
import com.nc.dragonbites.data.remote.DragonBitesAPI
import com.nc.dragonbites.data.remote.response.Recipe
import com.nc.dragonbites.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeListRepositoryImpl @Inject constructor(
    private val dragonBitesAPI: DragonBitesAPI,
    private val recipesDatabase: RecipesDatabase
): RecipeListRepository {
    override suspend fun getRecipes(): Flow<Resource<List<Recipe>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val recipes = recipesDatabase.recipeDao.getRecipes()
                if (recipes.isEmpty()) {
                    val remoteRecipes = dragonBitesAPI.getRecipes()
                    recipesDatabase.recipeDao.insertRecipes(remoteRecipes.asEntity())
                    emit(Resource.Success(remoteRecipes))
                    emit(Resource.Loading(false))
                } else {
                    emit(Resource.Success(recipes.asDomain()))
                    emit(Resource.Loading(false))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
                emit(Resource.Loading(false))
            }
        }
    }
}