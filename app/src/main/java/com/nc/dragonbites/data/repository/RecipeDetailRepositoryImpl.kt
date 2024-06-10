package com.nc.dragonbites.data.repository

import com.nc.dragonbites.data.local.RecipesDatabase
import com.nc.dragonbites.data.mappers.asDomain
import com.nc.dragonbites.data.mappers.asEntity
import com.nc.dragonbites.data.remote.DragonBitesAPI
import com.nc.dragonbites.data.remote.response.RecipeDetail
import com.nc.dragonbites.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeDetailRepositoryImpl @Inject constructor(
    private val dragonBitesAPI: DragonBitesAPI,
    private val recipesDatabase: RecipesDatabase
): RecipeDetailRepository {

    override suspend fun getRecipeDetail(id: String): Flow<Resource<RecipeDetail>> {
        return flow {
            try {
                emit(Resource.Loading())
                val recipeDetail = recipesDatabase.recipeDetailDao.getRecipeDetail(id)
                if (recipeDetail == null) {
                    val remoteRecipeDetail = dragonBitesAPI.getRecipeDetails(id)
                    recipesDatabase.recipeDetailDao.insertRecipeDetail(remoteRecipeDetail.asEntity())
                    emit(Resource.Success(remoteRecipeDetail))
                    emit(Resource.Loading(false))
                } else {
                    emit(Resource.Success(recipeDetail.asDomain()))
                    emit(Resource.Loading(false))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
                emit(Resource.Loading(false))
            }
        }
    }

}