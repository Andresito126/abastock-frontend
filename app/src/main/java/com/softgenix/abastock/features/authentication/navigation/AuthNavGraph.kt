package com.softgenix.abastock.features.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.abastock.core.navigation.CreateProduct
import com.softgenix.abastock.core.navigation.FeatureNavGraph
import com.softgenix.abastock.core.navigation.Inventory
import com.softgenix.abastock.core.navigation.Login
import com.softgenix.abastock.core.navigation.Register
import com.softgenix.abastock.core.navigation.Scanner
import com.softgenix.abastock.features.authentication.presentation.screens.SignInScreen
import com.softgenix.abastock.features.authentication.presentation.screens.SignUpScreen
import com.softgenix.abastock.features.inventory.presentation.screens.CreateProductScreen
import com.softgenix.abastock.features.inventory.presentation.screens.InventoryScreen
import com.softgenix.abastock.features.inventory.presentation.screens.ScannerScreen

class AuthNavGraph : FeatureNavGraph {
    override fun registerNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {

        navGraphBuilder.composable<Login> {
            SignInScreen(
                onNavigateToRegister = { navController.navigate(Register) },
                onLoginSuccess = {
                    navController.navigate(Inventory) {
                        popUpTo<Login> { inclusive = true }
                    }
                })
        }

        navGraphBuilder.composable<Register> {
            SignUpScreen(
                onNavigateToLogin = { navController.navigate(Login) },
                onSignUpSuccess = {
                    // aca puede ir la pantalla de exito pero ps aja awncha con un if tran tran tran
                },
                navController = navController
            )
        }
    }
}