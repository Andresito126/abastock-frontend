package com.softgenix.abastock.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.softgenix.abastock.R
import com.softgenix.abastock.core.shared.components.AbastockBottomBar
import com.softgenix.abastock.features.home.presentation.components.QuickActionItem
import com.softgenix.abastock.features.home.presentation.components.RecentSaleItem
import com.softgenix.abastock.features.home.presentation.components.TopProductCard

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            AbastockBottomBar(navController)
        },
        containerColor = Color(0xFFF7F8FA)
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {

            item {
                Text(
                    text = "Acciones rápidas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuickActionItem(
                        title = "Cobrar",
                        iconRes = R.drawable.ic_scanner,
                        containerColor =Color(0xFF1E3A5F),
                        contentColor = Color(0xFFECFDF5)
                    ) {
                        navController.navigate("scanner")
                    }

                    QuickActionItem(
                        title = "Agregar",
                        iconRes = R.drawable.ic_agregar,
                        containerColor = Color(0xFF16A34A),
                        contentColor = Color(0xFFECFDF5)
                    ) {
                        navController.navigate("create_product")
                    }

                    QuickActionItem(
                        title = "Ventas",
                        iconRes = R.drawable.ic_ventas,
                        containerColor = Color(0xFFD97706),
                        contentColor = Color(0xFFECFDF5)
                    ) { }

                    QuickActionItem(
                        title = "Stock",
                        iconRes = R.drawable.ic_inventory,
                        containerColor = Color(0xFF7C3AED),
                        contentColor = Color(0xFFECFDF5)
                    ) {
                        navController.navigate("inventory")
                    }
                }
                Spacer(Modifier.height(28.dp))
            }

                item {
                    Text("Más vendidos", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 12.dp))
                    LazyRow {
                        items(5) { index ->
                            TopProductCard("Coca-Cola 600ml", 15.0, 312)
                        }
                    }
                    Spacer(Modifier.height(24.dp))
                }

                item {
                    Text(
                        text = "Ventas recientes",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 12.dp, bottom = 8.dp)
                    )
                }

                items(5) {
                    RecentSaleItem(
                        name = "Coca-Cola 600ml",
                        time = "10:25 AM",
                        amount = 15.00
                    )
                }
            }
        }
        }


