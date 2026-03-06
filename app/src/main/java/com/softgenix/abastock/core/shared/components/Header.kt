package com.softgenix.abastock.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Header (
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xFF0F1C2E),
                        Color(0xFF1E3A5F),
                        Color(0xFF2A5298)
                    )
                )
            )
    ) {
        content()
    }
}