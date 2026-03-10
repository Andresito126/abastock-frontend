package com.softgenix.abastock.features.authentication.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatItem(value: String, label: String, valueColor: Color = Color.White) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = valueColor, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, lineHeight = 1.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(label, color = Color.White.copy(alpha = 0.55f), fontSize = 10.sp, lineHeight = 1.sp)
    }
}