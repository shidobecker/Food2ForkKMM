package br.com.shido.food2forkkmm.interactors.recipe_detail

import br.com.shido.food2forkkmm.datasource.network.RecipeService
import br.com.shido.food2forkkmm.domain.model.Recipe
import br.com.shido.food2forkkmm.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailRecipe(
    private val recipeService: RecipeService
) {

    fun execute(id: Int): Flow<DataState<Recipe>> = flow {
        //how can we emit loading?
        emit(DataState.loading())

        try {
            val recipe = recipeService.get(id)

            emit(DataState.data(null, recipe))
        } catch (e: Exception) {
            //How can we emit an error?
            emit(DataState.error<Recipe>(message = e.message ?: "Unknown Error"))

        }
    }


}