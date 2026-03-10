package com.softgenix.abastock.features.home.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopProductCard(name: String, price: Double, sold: Int) {
    Surface(
        modifier = Modifier.width(140.dp).padding(end = 12.dp),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box {
                Surface(
                    modifier = Modifier.fillMaxWidth().height(100.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFF5F5F5)
                ) { }
                Surface(
                    modifier = Modifier.padding(6.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                ) {
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(name, fontWeight = FontWeight.Bold, fontSize = 12.sp, maxLines = 1)
            Text("$$price", color = Color(0xFFF5A623), fontWeight = FontWeight.Bold)
            Text("$sold vendidos", fontSize = 10.sp, color = Color.Gray)
        }
    }
}