package com.nc.dragonbites.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nc.dragonbites.data.local.converters.IngredientsConverter
import com.nc.dragonbites.data.local.converters.MethodConverter

@Entity
data class RecipeDetailEntity (
    @PrimaryKey val id: String,
    val description: String,
    val difficulty: String,
    val image: String,
    @TypeConverters(IngredientsConverter::class)
    val ingredients: List<String>,
    @TypeConverters(MethodConverter::class)
    val method: List<Map<String, String>>,
    val portion: String,
    val time: String,
    val title: String
)