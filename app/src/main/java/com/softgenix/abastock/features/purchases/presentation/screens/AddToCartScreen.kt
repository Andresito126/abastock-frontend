package com.softgenix.abastock.features.purchases.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.softgenix.abastock.core.ui.theme.AccentGold
import com.softgenix.abastock.core.ui.theme.GrayLight
import com.softgenix.abastock.core.ui.theme.InputBg
import com.softgenix.abastock.core.ui.theme.InputBorder
import com.softgenix.abastock.core.ui.theme.NavyMid
import com.softgenix.abastock.core.ui.theme.SuccessGreen
import com.softgenix.abastock.core.ui.theme.Surface
import com.softgenix.abastock.core.ui.theme.TextPrim
import com.softgenix.abastock.core.ui.theme.TextSec
import com.softgenix.abastock.features.inventory.presentation.components.ProductCard

@Composable
fun AddToCartScreen(
    barcode: String,
    onAddedToCart: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Surface)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFFE3F2FD),
            border = BorderStroke(1.dp, Color(0xFF90CAF9))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Inventory2, contentDescription = null, tint = NavyMid)
                Spacer(Modifier.width(12.dp))
                Column {
                    Text("Stock actual: 3 unidades", fontWeight = FontWeight.Bold, color = NavyMid, fontSize = 14.sp)
                    Text("Se sumará al inventario existente", color = NavyMid.copy(alpha = 0.7f), fontSize = 12.sp)
                }
            }
        }

        Spacer(Modifier.height(24.dp))


        ProductCard {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(80.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = GrayLight
                ) { /* imgg */ }

                Spacer(Modifier.width(16.dp))

                Column {
                    Text("Sabritas Original 45g", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextPrim)
                    Text("Sabritas · Bolsa 45 g", color = TextSec, fontSize = 13.sp)
                    Spacer(Modifier.height(4.dp))
                    Surface(color = GrayLight, shape = RoundedCornerShape(8.dp)) {
                        Text(barcode, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), fontSize = 11.sp, color = TextSec)                    }
                }
            }
        }

        Spacer(Modifier.height(32.dp))

        Text("Cantidad comprada *", modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, color = TextPrim)
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = "50",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            suffix = { Text("unidades", color = TextSec) },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = InputBg, unfocusedBorderColor = InputBorder)
        )

        Spacer(Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Precio compra *", fontWeight = FontWeight.Bold, color = TextPrim)
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = "9", onValueChange = {}, prefix = { Text("$ ") }, shape = RoundedCornerShape(12.dp))
            }
            Column(modifier = Modifier.weight(1f)) {
                Text("Precio venta *", fontWeight = FontWeight.Bold, color = TextPrim)
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = "14", onValueChange = {}, prefix = { Text("$ ") }, shape = RoundedCornerShape(12.dp))
            }
        }

        Spacer(Modifier.height(32.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFE8F5E9),
            border = BorderStroke(1.dp, SuccessGreen)
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Margen de ganancia", fontSize = 12.sp, color = SuccessGreen)
                    Text("55.6%", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = SuccessGreen)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("Subtotal", fontSize = 12.sp, color = SuccessGreen)
                    Text("$450.00", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = SuccessGreen)
                }
            }
        }

        Spacer(Modifier.height(40.dp))

        Button(
            onClick = onAddedToCart,
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AccentGold)
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Agregar al Carrito", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}