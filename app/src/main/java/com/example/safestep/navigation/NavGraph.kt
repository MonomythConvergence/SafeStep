package com.example.bintesttask.app.com.example.safestep.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.features.presentation.ui.MainScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "main_screen", //todo refactor to onboarding once available
        modifier = modifier
    ) {
        composable("main_screen") {
            MainScreen()
                //todo add navigation to profile once available
                }

    }
}

