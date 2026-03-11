package com.softgenix.abastock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.softgenix.abastock.core.ui.theme.AbastockTheme
import com.softgenix.abastock.features.authentication.navigation.AuthNavGraph
import com.softgenix.abastock.features.authentication.presentation.screens.SignUpScreen
import com.softgenix.abastock.features.inventory.navigation.InventoryNavGraph
import com.softgenix.abastock.features.authentication.presentation.screens.SignUpSuccessScreen
import dagger.hilt.android.AndroidEntryPoint
import com.softgenix.abastock.core.navigation.NavigationWrapper

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val navGraphs = listOf(
            InventoryNavGraph(),
            AuthNavGraph()
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
                NavigationWrapper(
                    navGraphs = navGraphs
                )
            }
        }
    }
}
