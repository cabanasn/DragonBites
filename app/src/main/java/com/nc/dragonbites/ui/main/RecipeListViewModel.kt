package com.nc.dragonbites.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nc.dragonbites.data.repository.RecipeListRepository
import com.nc.dragonbites.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeListRepository
) : ViewModel() {

    private var _recipeListState = MutableStateFlow(RecipeListState())
    val recipeListState = _recipeListState.asStateFlow()

    init {
        fetchRecipeList()
    }

    private fun fetchRecipeList() {
        viewModelScope.launch {
            _recipeListState.update {
                it.copy(isLoading = true)
            }
            withContext(Dispatchers.IO) {
                repository.getRecipes().collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { recipes ->
                                _recipeListState.update {
                                    it.copy(isLoading = false, recipes = recipes)
                                }
                            }
                        }

                        is Resource.Error -> {
                            _recipeListState.update {
                                it.copy(isLoading = false)
                            }
                        }

                        is Resource.Loading -> {
                            _recipeListState.update {
                                it.copy(isLoading = it.isLoading)
                            }
                        }
                    }
                }
            }
        }
    }
}