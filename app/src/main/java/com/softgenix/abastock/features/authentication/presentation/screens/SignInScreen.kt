package com.softgenix.abastock.features.authentication.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.softgenix.abastock.core.shared.components.Header
import com.softgenix.abastock.features.authentication.presentation.components.StatItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignInScreen () {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "ABASTOCK",
                        modifier = Modifier.padding(top = 10.dp),
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                        lineHeight = 1.sp
                    )

                    Text(
                        text = "El control de tu tienda en tu bolsillo",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 15.sp
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .background(
                                Color(0xFFFFFFFF).copy(alpha = 0.12f),
                                shape = RoundedCornerShape(24.dp)
                            )
                            .width(320.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            StatItem("100+", "Tiendas")
                            Text("•", color = Color.White.copy(alpha = 0.2f))

                            StatItem("4.9 ★", "calificación")
                            Text("•", color = Color.White.copy(alpha = 0.2f))

                            StatItem("MX", "LATAM")
                        }
                    }
                }
            }

            Text(text = "Iniciar Sesión")
            Text(text = "Bienvenido de vuelta, tendero")
        }
    }
}