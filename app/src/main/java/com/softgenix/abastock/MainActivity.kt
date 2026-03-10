package com.softgenix.abastock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.softgenix.abastock.core.navigation.NavigationWrapper
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.softgenix.abastock.core.ui.theme.AbastockTheme
import com.softgenix.abastock.features.authentication.presentation.screens.SignInScreen
import com.softgenix.abastock.features.inventory.navigation.InventoryNavGraph
import com.softgenix.abastock.features.authentication.presentation.screens.SignUpScreen
import com.softgenix.abastock.features.authentication.presentation.screens.SignUpSuccessScreen
import com.softgenix.abastock.features.home.presentation.screens.HomeScreen
import com.softgenix.abastock.features.inventory.presentation.screens.AddToCartScreen
import com.softgenix.abastock.features.inventory.presentation.screens.InventoryScreen
import com.softgenix.abastock.features.inventory.presentation.screens.PurchaseEmptyCartScreen
import com.softgenix.abastock.features.inventory.presentation.screens.PurchaseScannerScreen
import com.softgenix.abastock.features.inventory.presentation.screens.PurchaseSummaryScreen
import com.softgenix.abastock.features.inventory.presentation.screens.ScannerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val navGraphs = listOf(
            InventoryNavGraph()
        )

        setContent {
            val systemUiController = rememberSystemUiController()
            val navController = rememberNavController()
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }

            AbastockTheme {
                HomeScreen(navController)
            }
        }
    }
    }
