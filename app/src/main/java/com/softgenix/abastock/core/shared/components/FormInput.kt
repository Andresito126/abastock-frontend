package com.softgenix.abastock.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormInput (
    label: String,
    icon: Int,
    isPasswordField: Boolean? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text (
            text = label,
            color = Color(0xFF9FA3A9),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )

        if ( isPasswordField == true ) {
            Text (
                text = "¿Olvidaste tu contraseña?",
                modifier = Modifier
                    .clickable(
                        onClick = {}
                    ),
                color = Color(0xFF9FA3A9),
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFFFFFFF))
            .border(
                width = 1.dp,
                color = Color(0xFFE5E7EB),
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFF9FAFB))
                .fillMaxHeight()
                .width(50.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(icon),
                contentDescription = "",
                tint = Color(0xFF9CA3AF),
                modifier = Modifier.size(20.dp)
            )
        }

        VerticalDivider(
            color = Color(0xFFE5E7EB),
            thickness = 1.dp,
            modifier = Modifier.fillMaxHeight()
        )

        TextField (
            onValueChange = {},
            value = "",
            modifier = Modifier.fillMaxSize(),
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

}