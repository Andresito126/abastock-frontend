package com.softgenix.abastock.features.purchases.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.softgenix.abastock.core.ui.theme.AccentGold
import com.softgenix.abastock.core.ui.theme.ErrorRed
import com.softgenix.abastock.core.ui.theme.GrayLight
import com.softgenix.abastock.core.ui.theme.NavyMid
import com.softgenix.abastock.core.ui.theme.SuccessGreen
import com.softgenix.abastock.core.ui.theme.Surface
import com.softgenix.abastock.core.ui.theme.TextPrim
import com.softgenix.abastock.core.ui.theme.TextSec
import com.softgenix.abastock.features.inventory.presentation.components.ProductCard

@Composable
fun PurchaseSummaryScreen(
    onFinish: () -> Unit,
    onScanAnother: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Surface)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Productos en la compra",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = TextPrim,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            item {
                ProductCard {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(modifier = Modifier.size(65.dp), shape = RoundedCornerShape(12.dp), color = GrayLight) { }

                        Spacer(Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text("Sabritas Original 45g", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("Sabritas", color = TextSec, fontSize = 12.sp)

                            Row(modifier = Modifier.padding(top = 8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                Column {
                                    Text("Cantidad", fontSize = 10.sp, color = TextSec)
                                    Text("50 uds", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }
                                Column {
                                    Text("P. Compra", fontSize = 10.sp, color = TextSec)
                                    Text("$9.00", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Icon(Icons.Default.Delete, contentDescription = null, tint = ErrorRed, modifier = Modifier.size(20.dp))
                            Spacer(Modifier.height(16.dp))
                            Text("Subtotal", fontSize = 10.sp, color = TextSec)
                            Text("$450.00", color = AccentGold, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedButton(
                onClick = { onScanAnother },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.5.dp, NavyMid)
            ) {
                Icon(Icons.Default.QrCodeScanner, contentDescription = null, tint = NavyMid)
                Spacer(Modifier.width(8.dp))
                Text("Escanear Otro Producto", color = NavyMid, fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = { onFinish },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Finalizar Compra", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}