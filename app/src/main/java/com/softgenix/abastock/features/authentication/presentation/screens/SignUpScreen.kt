package com.softgenix.abastock.features.authentication.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softgenix.abastock.R
import com.softgenix.abastock.core.shared.components.Button
import com.softgenix.abastock.core.shared.components.Header
import com.softgenix.abastock.core.shared.components.InputLabel
import com.softgenix.abastock.core.shared.components.StyledInput
import com.softgenix.abastock.core.ui.theme.IconTint
import com.softgenix.abastock.core.ui.theme.NavyMid
import com.softgenix.abastock.core.ui.theme.Surface
import com.softgenix.abastock.core.ui.theme.TextSec

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen() {

    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val passwordsMatch = confirmPassword.isEmpty() || password == confirmPassword

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Surface)
            .navigationBarsPadding()
    ) {
        // HEADER
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            ) {
                Header(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .offset(x = 5.dp, y = 140.dp)
                            .background(
                                Color.White.copy(alpha = 0.05f),
                                CircleShape
                            )
                    )

                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.TopEnd)
                            .offset(x = 25.dp, y = (-25).dp)
                            .background(
                                Color.White.copy(alpha = 0.06f),
                                CircleShape
                            )
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 18.dp, vertical = 50.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ) { },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.back_icon),
                                contentDescription = null,
                                tint = IconTint,
                                modifier = Modifier.size(20.dp)
                            )

                            Text(
                                text = "Volver",
                                modifier = Modifier.padding(start = 7.dp),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }

                        Spacer(Modifier.height(18.dp))

                        Text(
                            text = "Tu negocio",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 26.sp
                        )

                        Spacer(Modifier.height(6.dp))

                        Text(
                            text = "Cuéntanos sobre tu tienda y\ncrea tus credenciales de acceso",
                            color = Color.White.copy(alpha = 0.65f),
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }

        // FORMULARIO
        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = -(40).dp)
                    .background(
                        Surface,
                        RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                    )
                    .padding(horizontal = 18.dp, vertical = 24.dp)
            ) {

                Text(
                    text = "Crear cuenta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )

                Text(
                    text = "Completa la información para empezar",
                    fontSize = 13.sp,
                    color = TextSec
                )

                Spacer(Modifier.height(15.dp))

                // TIENDA
                InputLabel("Nombre de tu tienda")
                Spacer(Modifier.height(4.dp))
                StyledInput(
                    value = "",
                    onValueChange = {},
                    placeholder = "Abarrotito",
                    leadingIconRes = R.drawable.store_icon
                )

                Spacer(Modifier.height(18.dp))

                // NOMBRE
                InputLabel("Nombre completo")
                Spacer(Modifier.height(4.dp))
                StyledInput(
                    value = "",
                    onValueChange = {},
                    placeholder = "Julian Gutiérrez Alcazar",
                    leadingIconRes = R.drawable.person_icon
                )

                Spacer(Modifier.height(18.dp))

                // CELULAR
                InputLabel("Número de celular")
                Spacer(Modifier.height(4.dp))
                StyledInput(
                    value = "",
                    onValueChange = {},
                    placeholder = "55 1234 5678",
                    leadingIconRes = R.drawable.call_icon
                )

                Spacer(Modifier.height(18.dp))

                // EMAIL
                InputLabel("Correo electrónico")
                Spacer(Modifier.height(4.dp))
                StyledInput(
                    value = "",
                    onValueChange = {},
                    placeholder = "julian@gmail.com",
                    leadingIconRes = R.drawable.email_icon
                )

                Spacer(Modifier.height(18.dp))

                // PASSWORD
                InputLabel("Contraseña")
                Spacer(Modifier.height(4.dp))
                StyledInput(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Mínimo 8 caracteres",
                    leadingIconRes = R.drawable.icon_password,
                    isPassword = true,
                    passwordVisible = passwordVisible,
                    onTogglePassword = { passwordVisible = !passwordVisible }
                )

                Spacer(Modifier.height(18.dp))

                // CONFIRM PASSWORD
                InputLabel("Confirmar contraseña")
                Spacer(Modifier.height(4.dp))
                StyledInput(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "Repite tu contraseña",
                    leadingIconRes = R.drawable.icon_password,
                    isPassword = true,
                    passwordVisible = confirmPasswordVisible,
                    onTogglePassword = { confirmPasswordVisible = !confirmPasswordVisible },
                    isError = !passwordsMatch
                )

                if (!passwordsMatch) {
                    Text(
                        text = "Las contraseñas no coinciden",
                        color = Color(0xFFD32F2F),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 4.dp, top = 5.dp)
                    )
                }

                Spacer(Modifier.height(32.dp))

                // BOTON
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(
                        nameAction = "Crear mi cuenta",
                        colors = ButtonColors(
                            containerColor = Color(0xFFF5A623),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0xFFF5A623),
                            disabledContentColor = Color.White.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(18.dp))

                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = TextSec,
                                    fontSize = 12.sp
                                )
                            ) {
                                append("¿Ya tienes una cuenta?  ")
                            }
                            withStyle(
                                SpanStyle(
                                    color = NavyMid,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Iniciar Sesión")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {},
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
