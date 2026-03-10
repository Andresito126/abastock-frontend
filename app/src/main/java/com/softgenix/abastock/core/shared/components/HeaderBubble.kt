package com.softgenix.abastock.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.softgenix.abastock.core.shared.entities.Bubble

@Composable
fun BoxScope.HeaderBubble (
    bubble1: Bubble,
    bubble2: Bubble
) {
    Box(
        modifier = Modifier
            .size(bubble2.size.dp)
            .offset(x = (bubble2.posX).dp, y = (bubble2.posY).dp)
            .background(
                Color.White.copy(alpha = 0.05f),
                CircleShape
            )
    )

    Box(
        modifier = Modifier
            .size(bubble1.size.dp)
            .align(Alignment.TopEnd)
            .offset(x = (bubble1.posX).dp, y = (bubble1.posY).dp)
            .background(
                Color.White.copy(alpha = 0.06f),
                CircleShape
            )
    )
}