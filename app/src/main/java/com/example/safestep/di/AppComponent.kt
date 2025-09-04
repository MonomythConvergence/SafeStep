package com.example.bintesttask.app.com.example.safestep.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: com.example.safestep.MainActivity)
}