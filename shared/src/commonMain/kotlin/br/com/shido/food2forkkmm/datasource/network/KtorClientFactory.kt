package br.com.shido.food2forkkmm.datasource.network

import br.com.shido.food2forkkmm.datasource.network.model.RecipeDto
import br.com.shido.food2forkkmm.domain.model.Recipe
import br.com.shido.food2forkkmm.domain.util.DateTimeUtil
import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient
}


fun RecipeDto.toRecipe(): Recipe {
    val datetimeUtil = DateTimeUtil()
    return Recipe(
        id = pk,
        title = title,
        featuredImage = featuredImage,
        rating = rating,
        publisher = publisher,
        sourceUrl = sourceUrl,
        ingredients = ingredients,
        dateAdded = datetimeUtil.toLocalDate(longDateAdded.toDouble()),
        dateUpdated = datetimeUtil.toLocalDate(longDateUpdated.toDouble())
    )
}

fun List<RecipeDto>.toRecipeList(): List<Recipe> {
    return map { it.toRecipe() }
}