package com.nc.dragonbites.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nc.dragonbites.data.local.entity.RecipeDetailEntity

@Dao
interface RecipeDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeDetail(recipeDetail: RecipeDetailEntity)

    @Query("SELECT * FROM RecipeDetailEntity WHERE id = :id")
    suspend fun getRecipeDetail(id: String): RecipeDetailEntity?
}