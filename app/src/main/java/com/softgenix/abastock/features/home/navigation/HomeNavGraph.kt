package com.softgenix.abastock.features.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.abastock.core.navigation.CreateProduct
import com.softgenix.abastock.core.navigation.FeatureNavGraph
import com.softgenix.abastock.core.navigation.Home
import com.softgenix.abastock.core.navigation.Inventory
import com.softgenix.abastock.core.navigation.Scanner
import com.softgenix.abastock.features.home.presentation.screens.HomeScreen

class HomeNavGraph: FeatureNavGraph {
    override fun registerNavGraph (navGraphBuilder: NavGraphBuilder, navController: NavHostController){
        navGraphBuilder.composable <Home>{
            HomeScreen(
                onNavigateToPay = {
                    navController.navigate(Scanner)
                },
                onNavigateToAddProducts = {
                    navController.navigate(CreateProduct)
                },
                onNavigateToInventory = {
                    navController.navigate(Inventory)
                },
                onNavigateToSales = {
                    navController.navigate(Inventory)
                },
                navController
            )
        }
    }
}