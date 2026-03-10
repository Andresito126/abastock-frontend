package com.softgenix.abastock.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper(
    navGraphs : List<FeatureNavGraph>,
    startDestination: Any = Home
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        navGraphs.forEach { graph ->
            graph.registerNavGraph(this, navController)
        }
    }
}