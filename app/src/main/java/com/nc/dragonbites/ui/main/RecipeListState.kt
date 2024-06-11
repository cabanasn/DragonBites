package com.nc.dragonbites.ui.main

import com.nc.dragonbites.data.remote.response.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList()
)