package br.com.shido.food2forkkmm.android.di

import br.com.shido.food2forkkmm.android.BASE_URL
import br.com.shido.food2forkkmm.datasource.network.KtorClientFactory
import br.com.shido.food2forkkmm.datasource.network.RecipeService
import br.com.shido.food2forkkmm.datasource.network.RecipeServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun providesRecipeService(
        httpClient: HttpClient
    ): RecipeService {
        return RecipeServiceImpl(httpClient, baseURL = BASE_URL)
    }

}