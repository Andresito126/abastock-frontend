package com.softgenix.abastock.features.inventory.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softgenix.abastock.R
import com.softgenix.abastock.core.shared.components.InputLabel
import com.softgenix.abastock.core.shared.components.StyledInput
import com.softgenix.abastock.core.ui.theme.TextSec

@Composable
fun InventoryItem(
    name: String,
    brand: String,
    category: String,
    price: Double,
    stock: Int,
    maxStock: Int = 50, //bara progrsodora
    imageUrl: String,
    onItemClick: () -> Unit
) {

    //luego lo meto al viewmodel
    val isLowStock = stock < 5
    val statusColor = if (isLowStock) MaterialTheme.colorScheme.error else Color(0xFF4CAF50)
    val statusText = if (isLowStock) "$stock · ¡Agotándose!" else "$stock · En stock"

    ProductCard(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable { onItemClick() }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Surface(
                modifier = Modifier.size(70.dp),
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFF5F5F5)
            ) {

            }

            Spacer(Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text("$brand · $category", color = Color.Gray, fontSize = 12.sp)

                Spacer(Modifier.height(8.dp))

                LinearProgressIndicator(
                    progress = stock.toFloat() / maxStock,
                    modifier = Modifier.fillMaxWidth().height(6.dp).clip(CircleShape),
                    color = statusColor,
                    trackColor = statusColor.copy(alpha = 0.1f)
                )
                Text(statusText, color = statusColor, fontSize = 11.sp, fontWeight = FontWeight.Medium)
            }

            Text(
                text = "$${String.format("%.2f", price)}",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}