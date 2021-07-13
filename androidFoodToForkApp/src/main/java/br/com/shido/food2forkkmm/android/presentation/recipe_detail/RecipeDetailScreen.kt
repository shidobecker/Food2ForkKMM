package br.com.shido.food2forkkmm.android.presentation.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import br.com.shido.food2forkkmm.domain.model.Recipe

@Composable
fun RecipeDetailScreen(
    recipe: Recipe?,
) {
    if(recipe == null){
        Text(text = "Error")
    }else{
        Text("RecipeDetailScreen $recipe")
    }
}