package com.softgenix.abastock.features.inventory.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softgenix.abastock.R
import com.softgenix.abastock.core.shared.components.InputLabel
import com.softgenix.abastock.core.shared.components.StyledInput
import com.softgenix.abastock.core.ui.theme.TextSec

@Composable
fun CreateProductScreen() {
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
                .background(colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 32.dp)
    ) {
        // img y seccion
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                Surface(
                    modifier = Modifier.size(130.dp),
                    shape = RoundedCornerShape(24.dp),
                    color = Color.White,
                    shadowElevation = 2.dp
                ) {
                    Icon(
                        Icons.Default.Inventory,
                        contentDescription = null,
                        tint = colorScheme.onBackground.copy(alpha = 0.2f),
                        modifier = Modifier.padding(35.dp)
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Código del producto: 123456789",
                color = TextSec,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        // info
        Surface(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            shape = RoundedCornerShape(24.dp),
            color = Color.White
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Información del producto",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.primary
                )
                Spacer(Modifier.height(16.dp))

                InputLabel("Nombre")
                StyledInput(
                    value = "Sabritas Adobadas 45g",
                    placeholder = "name",
                    onValueChange = {},
                    leadingIconRes = R.drawable.name_icon,
                    readOnly = true
                )

                Spacer(Modifier.height(12.dp))

                InputLabel("Marca / Fabricante")
                StyledInput(
                    value = "Sabritas",
                    placeholder = "Marca",
                    onValueChange = {},
                    leadingIconRes = R.drawable.marca_icon,
                    readOnly = true
                )

                Spacer(Modifier.height(12.dp))

                InputLabel("Presentación")
                StyledInput(
                    value = "Bolsa 45 g",
                    placeholder = "presentation",
                    onValueChange = {},
                    leadingIconRes = R.drawable.presentation_icon,
                    readOnly = true
                )

                Spacer(Modifier.height(12.dp))

                InputLabel("Categoría")
                StyledInput(
                    value = "Sabritas",
                    placeholder = "Category",
                    onValueChange = {},
                    leadingIconRes = R.drawable.category_icon,
                    readOnly = true
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // precio y stock
        Surface(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            shape = RoundedCornerShape(24.dp),
            color = Color.White
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Precios y stock (obligatorio)",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.primary
                )
                Spacer(Modifier.height(16.dp))

                InputLabel("Precio de costo")
                StyledInput(
                    value = "10.00",
                    placeholder = "0.00",
                    onValueChange = {},
                    leadingIconRes = R.drawable.money_icon
                )

                Spacer(Modifier.height(12.dp))

                InputLabel("Precio de venta")
                StyledInput(
                    value = "15.00",
                    placeholder = "0.00",
                    onValueChange = {},
                    leadingIconRes = R.drawable.money_icon
                )

                Spacer(Modifier.height(16.dp))

                InputLabel("Stock Inicial")
                StyledInput(
                    value = "10",
                    placeholder = "Stock",
                    onValueChange = {},
                    leadingIconRes = R.drawable.stock_icon
                )

                Spacer(Modifier.height(12.dp))

                InputLabel("Alerta de stock mínimo")
                StyledInput(
                    value = "10",
                    placeholder = "Stock",
                    onValueChange = {},
                    leadingIconRes = R.drawable.stock_alert_icon
                )

            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(58.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorScheme.primary)
        ) {
            Text("Guardar producto", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}