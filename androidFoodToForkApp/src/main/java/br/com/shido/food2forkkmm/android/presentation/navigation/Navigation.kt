package br.com.shido.food2forkkmm.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import br.com.shido.food2forkkmm.android.presentation.recipe_detail.RecipeDetailScreen
import br.com.shido.food2forkkmm.android.presentation.recipe_detail.RecipeDetailViewModel
import br.com.shido.food2forkkmm.android.presentation.recipe_list.RecipeListScreen
import br.com.shido.food2forkkmm.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            val factory =
                HiltViewModelFactory(LocalContext.current, navBackStackEntry = navBackStackEntry)

            val viewModel: RecipeListViewModel = viewModel(
                key = "RecipeListViewModel",
                factory = factory
            )
            RecipeListScreen { recipeId ->
                navController.navigate(Screen.RecipeDetail.route + "/$recipeId") //Passing the argument
            }
        }

        //Saying composable will accept an argument of recipeId
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val factory =
                HiltViewModelFactory(LocalContext.current, navBackStackEntry = navBackStackEntry)

            val viewModel: RecipeDetailViewModel = viewModel(
                key = "RecipeDetailViewModel",
                factory = factory
            )
            //val vm = hiltViewModel<RecipeDetailViewModel>() - > This also works - recent version

            RecipeDetailScreen(recipeId = viewModel.recipeId.value)
            // RecipeDetailScreen(recipeId = navBackStackEntry.arguments?.getInt("recipeId")) //Getting the argument
        }
    }

}