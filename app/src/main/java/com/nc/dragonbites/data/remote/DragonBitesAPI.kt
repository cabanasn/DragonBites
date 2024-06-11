package com.nc.dragonbites.data.remote

import com.nc.dragonbites.data.remote.response.Recipe
import com.nc.dragonbites.data.remote.response.RecipeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBitesAPI {

    @GET("/")
    suspend fun getRecipes(): List<Recipe>

    @GET("{id}")
    suspend fun getRecipeDetails(
        @Path("id") id: String
    ): RecipeDetail

    companion object {
        const val BASE_URL = "https://chinese-food-db.p.rapidapi.com/"
        const val API_HOST = "chinese-food-db.p.rapidapi.com"
        const val API_KEY = "08c736c478mshe7a82d58ededa51p19d573jsnaf6f3e038d9f"
    }

}