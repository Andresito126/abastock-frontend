package com.softgenix.abastock.core.shared.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Button (
    nameAction: String,
    icon: Int? = null,
    contentDescriptionIcon: String? = null,
    colors: ButtonColors,
    modifier: Modifier = Modifier
) {

    Button(
        onClick = {},
        modifier = modifier.height(50.dp),
        colors = colors
    ) {
        if (icon == null) { Text(text = nameAction) }
        else {
            Row(){
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescriptionIcon,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = nameAction,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
    }


}