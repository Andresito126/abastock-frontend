package com.softgenix.abastock.features.authentication.presentation.components

import androidx.compose.foundation.layout.Arrangement
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
fun StatItem(
    value: String,
    label: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            color = Color(0xFFF5A623),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            lineHeight = 1.sp
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = label,
            color = Color(0xFFFFFFFF).copy(alpha = 0.6f),
            fontSize = 12.sp,
            lineHeight = 1.sp
        )
    }
}