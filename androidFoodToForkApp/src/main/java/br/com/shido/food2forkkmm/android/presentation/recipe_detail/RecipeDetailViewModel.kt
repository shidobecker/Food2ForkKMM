package br.com.shido.food2forkkmm.android.presentation.recipe_detail


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.shido.food2forkkmm.datasource.network.RecipeService
import br.com.shido.food2forkkmm.domain.model.Recipe
import br.com.shido.food2forkkmm.interactors.recipe_detail.DetailRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandler: SavedStateHandle,
    private val detailRecipe: DetailRecipe
) : ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        savedStateHandler.get<Int>("recipeId")?.let { recipeId ->
             detailRecipe.execute(recipeId).onEach { data ->
                 println(data.data)
                 this.recipe.value = data.data
             }.launchIn(viewModelScope)
        }
    }

}


