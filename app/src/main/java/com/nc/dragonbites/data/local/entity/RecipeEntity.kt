package com.nc.dragonbites.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeEntity (
    @PrimaryKey val id: String,
    val difficulty: String,
    val image: String,
    val title: String
)