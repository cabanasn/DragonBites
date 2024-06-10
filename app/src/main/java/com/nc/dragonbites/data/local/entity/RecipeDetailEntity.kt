package com.nc.dragonbites.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeDetailEntity (
    @PrimaryKey val id: String,
    val description: String,
    val difficulty: String,
    val image: String,
    val ingredients: List<String>,
    val method: List<Map<String, String>>,
    val portion: String,
    val time: String,
    val title: String
)