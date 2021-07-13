package br.com.shido.food2forkkmm.android.presentation.recipe_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.shido.food2forkkmm.interactors.recipe_list.SearchRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle, //don't need for this VM
    private val searchRecipes: SearchRecipes
) : ViewModel() {

    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        searchRecipes.execute(1, "chicken").onEach { dataState ->
            println("Recipe list View model ${dataState.isLoading}")
            dataState.data?.let { recipes ->
                println("Recipe list View model ${recipes}")

            }

            dataState.message?.let { message ->
                println("Message $message")
            }
        }.launchIn(viewModelScope)
    }
}