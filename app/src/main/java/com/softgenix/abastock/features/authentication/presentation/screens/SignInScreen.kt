package com.softgenix.abastock.features.authentication.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.softgenix.abastock.R
import com.softgenix.abastock.core.shared.components.Button
import com.softgenix.abastock.core.shared.components.FormInput
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
                .background(Color(0xFFF7F8FA))

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
                        modifier = Modifier.padding(top = 30.dp),
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        top = 25.dp,
                        end = 15.dp,
                        bottom = 0.dp
                    )
            ) {
                Text(
                    text = "Iniciar sesión",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Bienvenido de vuelta, tendero",
                    color = Color(0xFF9FA3A9),
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                FormInput(
                    label = "Teléfono o correo",
                    icon = R.drawable.call_icon
                )

                Spacer(modifier = Modifier.height(15.dp))

                FormInput(
                    label = "Contraseña",
                    icon = R.drawable.icon_password,
                    isPasswordField = true
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    nameAction = "Iniciar sesión",
                    colors = ButtonColors(
                        containerColor = Color(0xFF1E3A5F),
                        contentColor = Color.White,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
//                        .background(Brush.linearGradient(
//                            listOf(
//                                Color(0xFF1E3A5F),
//                                Color(0xFF2A5298)
//                            )
//                        ))

                )

                Spacer(modifier = Modifier.height(25.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        color = Color(0xFFE5E7EB),
                        thickness = 1.dp,
                        modifier = Modifier.weight(0.3f)
                    )

                    Text(
                        text = "o continúa con",
                        modifier = Modifier.padding(horizontal = 10.dp),
                        fontSize = 12.sp,
                        color = Color(0xFF9CA3AF)
                    )

                    HorizontalDivider(
                        color = Color(0xFFE5E7EB),
                        thickness = 1.dp,
                        modifier = Modifier.weight(0.3f)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    nameAction = "Google",
                    icon = R.drawable.google_icon,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF),
                        contentColor = Color.Black,
                        disabledContainerColor = Color(0xFFFFFFFF),
                        disabledContentColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))

                )

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    nameAction = "Apple",
                    icon = R.drawable.apple_icon,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Black,
                        disabledContentColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))

                )

            }

        }
    }
}