package com.softgenix.abastock.features.authentication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StatDot() {
    Box(
        modifier = Modifier
            .size(4.dp)
            .background(Color.White.copy(alpha = 0.25f), CircleShape)
    )
}