package com.softgenix.abastock.features.purchases.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.softgenix.abastock.core.navigation.AddToCart
import com.softgenix.abastock.core.navigation.CreateProduct
import com.softgenix.abastock.core.navigation.FeatureNavGraph
import com.softgenix.abastock.core.navigation.Home
import com.softgenix.abastock.core.navigation.PurchaseEmptyCart
import com.softgenix.abastock.core.navigation.PurchaseScanner
import com.softgenix.abastock.core.navigation.PurchaseSummary
import com.softgenix.abastock.features.purchases.presentation.screens.AddToCartScreen
import com.softgenix.abastock.features.purchases.presentation.screens.PurchaseEmptyCartScreen
import com.softgenix.abastock.features.purchases.presentation.screens.PurchaseScannerScreen
import com.softgenix.abastock.features.purchases.presentation.screens.PurchaseSummaryScreen

class PurchasesNavGraph: FeatureNavGraph {
    override fun registerNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {

        navGraphBuilder.composable<PurchaseEmptyCart> {
            PurchaseEmptyCartScreen(
                onNavigateToScanner = { navController.navigate(PurchaseScanner) }
            )
        }

        navGraphBuilder.composable<PurchaseScanner> {
            PurchaseScannerScreen(
                onBarcodeDetected = { barcode ->

                    // if (productExists) navController.navigate(AddToCart(barcode))
                    // else navController.navigate(CreateProduct(barcode))
                    navController.navigate(CreateProduct(barcode))
                }
            )
        }

        navGraphBuilder.composable<AddToCart> { backStackEntry ->
            val route: AddToCart = backStackEntry.toRoute()
            AddToCartScreen(
                barcode = route.barcode,
                onAddedToCart = { navController.navigate(PurchaseSummary) }
            )
        }


        navGraphBuilder.composable<PurchaseSummary> {
            PurchaseSummaryScreen(
                onFinish = { navController.navigate(Home) },
                onScanAnother = { navController.navigate(PurchaseScanner) }
            )
        }


    }
}