package com.softgenix.abastock.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureNavGraph {
    fun registerNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    )
}