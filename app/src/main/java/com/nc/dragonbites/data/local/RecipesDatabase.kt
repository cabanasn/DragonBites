package com.nc.dragonbites.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nc.dragonbites.data.local.entity.RecipeDetailEntity
import com.nc.dragonbites.data.local.entity.RecipeEntity

@Database(
    entities = [RecipeEntity::class, RecipeDetailEntity::class],
    version = 1,
    exportSchema = true
)
abstract class RecipesDatabase : RoomDatabase() {
    abstract val recipeDao: RecipeDao
    abstract val recipeDetailDao: RecipeDetailDao
}