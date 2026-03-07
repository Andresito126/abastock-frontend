package com.softgenix.abastock.core.shared.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.softgenix.abastock.core.ui.theme.TextPrim

@Composable
fun InputLabel(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        color = TextPrim
    )
}