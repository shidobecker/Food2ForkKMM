package br.com.shido.food2forkkmm.android.di

import br.com.shido.food2forkkmm.datasource.network.RecipeService
import br.com.shido.food2forkkmm.interactors.recipe_detail.DetailRecipe
import br.com.shido.food2forkkmm.interactors.recipe_list.SearchRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(
        recipeService: RecipeService
    ): SearchRecipes {
        return SearchRecipes(recipeService = recipeService)
    }


    @Singleton
    @Provides
    fun provideDetailRecipe(
        recipeService: RecipeService
    ): DetailRecipe {
        return DetailRecipe(recipeService = recipeService)
    }

}