package br.com.shido.food2forkkmm.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

interface Dummy {
    fun description(): String
}

class DummyImp(private val dummyCapacity: Int) : Dummy {
    override fun description(): String {
        return "Dummy $dummyCapacity"
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DummyModule {

    @Singleton
    @Provides
    fun provideDummyCapacity(): Int {
        return 5
    }

    @Singleton
    @Provides
    fun provideDummy(dummyCapacity: Int): Dummy {
        return DummyImp(dummyCapacity = provideDummyCapacity())
    }

}