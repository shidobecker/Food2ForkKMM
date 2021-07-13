package br.com.shido.food2forkkmm.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import br.com.shido.food2forkkmm.android.presentation.navigation.Navigation
import br.com.shido.food2forkkmm.datasource.network.KtorClientFactory
import br.com.shido.food2forkkmm.datasource.network.RecipeServiceImpl
import br.com.shido.food2forkkmm.datasource.network.model.RecipeDto
import br.com.shido.food2forkkmm.datasource.network.toRecipe
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
const val BASE_URL = "https://food2fork.ca/api/recipe"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigation()
        }

    }
}
