package com.example.bintesttask.app.com.example.safestep.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class AppModule {
    // Bind factory
    @Binds
    abstract fun bindVmFactory(factory: SimpleVmFactory): ViewModelProvider.Factory

    // Bind your single VM into the map
    @Binds
    @IntoMap
    @ClassKey(com.example.safestep.features.MainViewModel::class)
    abstract fun bindSensorViewModel(vm: com.example.safestep.feature.SensorViewModel): ViewModel

    companion object {
        // provide any deps your VM needs here, e.g. a repository stub
        @Provides
        @Singleton
        fun provideSomeRepo(): com.example.safestep.data.SomeRepository = com.example.safestep.data.SomeRepositoryImpl()
    }
}