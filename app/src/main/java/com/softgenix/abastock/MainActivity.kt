package com.softgenix.abastock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.softgenix.abastock.core.navigation.NavigationWrapper
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.softgenix.abastock.core.ui.theme.AbastockTheme
import com.softgenix.abastock.features.inventory.navigation.InventoryNavGraph
import com.softgenix.abastock.features.home.navigation.HomeNavGraph
import com.softgenix.abastock.features.purchases.navigation.PurchasesNavGraph
import com.softgenix.abastock.features.sales.navigation.SalesNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val navGraphs = listOf(
            InventoryNavGraph(),
            HomeNavGraph(),
            PurchasesNavGraph(),
            SalesNavGraph()
        )

        setContent {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }

            AbastockTheme() {
                NavigationWrapper(
                    navGraphs = navGraphs,
                )
            }
        }
    }
}
