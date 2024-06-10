package com.nc.dragonbites.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.nc.dragonbites.data.local.entity.RecipeEntity

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<RecipeEntity>)

    @Query("SELECT * FROM RecipeEntity")
    suspend fun getRecipes(): List<RecipeEntity>
}