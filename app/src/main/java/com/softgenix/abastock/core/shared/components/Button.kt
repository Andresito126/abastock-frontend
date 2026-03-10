package com.softgenix.abastock.core.shared.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(
    nameAction: String,
    icon: Int? = null,
    contentDescriptionIcon: String? = null,
    colors: ButtonColors,
    outlined: Boolean = false,
    borderColor: Color = Color(0xFFE2E6EE),
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val shape = RoundedCornerShape(14.dp)

    val baseModifier = modifier
        .height(50.dp)
        .then(
            if (outlined) Modifier.border(1.dp, borderColor, shape)
            else Modifier
        )

    Button(
        onClick = onClick,
        modifier = baseModifier,
        shape = shape,
        colors = colors,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.5.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        if (icon == null) {
            Text(
                text = nameAction,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                letterSpacing = 0.3.sp
            )
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescriptionIcon,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    text = nameAction,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
            }
        }
    }
}