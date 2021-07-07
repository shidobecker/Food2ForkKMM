package br.com.shido.food2forkkmm.android.presentation.recipe_detail


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.com.shido.food2forkkmm.android.di.Dummy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandler: SavedStateHandle,
    private val dummy: Dummy
) : ViewModel() {

    val recipeId: MutableState<Int?> = mutableStateOf(null)

    init {
        savedStateHandler.get<Int>("recipeId")?.let { recipeId ->
            this.recipeId.value = recipeId
        }

        println(
            "Recipe Detail View Model ${
                dummy
                    .description()
            }"
        )
    }

}


