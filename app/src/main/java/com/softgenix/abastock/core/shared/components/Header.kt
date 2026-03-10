package com.softgenix.abastock.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.softgenix.abastock.core.ui.theme.NavyDark
import com.softgenix.abastock.core.ui.theme.NavyLight
import com.softgenix.abastock.core.ui.theme.NavyMid

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
                        NavyDark,
                        NavyMid,
                        NavyLight
                    )
                )
            )
    ) {
        content()
    }
}