package br.com.shido.food2forkkmm.interactors.recipe_list

import br.com.shido.food2forkkmm.datasource.network.RecipeService
import br.com.shido.food2forkkmm.domain.model.Recipe
import br.com.shido.food2forkkmm.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService
) {

    fun execute(page: Int, query: String): Flow<DataState<List<Recipe>>> = flow {
        //how can we emit loading?
        emit(DataState.loading())

        try {
            val recipes = recipeService.search(page, query)
            emit(DataState.data(null, recipes))
        } catch (e: Exception) {
            //How can we emit an error?
            emit(DataState.error<List<Recipe>>(message = e.message ?: "Unknown Error"))

        }
    }

}