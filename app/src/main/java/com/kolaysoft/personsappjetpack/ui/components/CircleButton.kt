package com.kolaysoft.personsappjetpack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolaysoft.personsappjetpack.ui.theme.ButtonColor

@Composable
fun CircleButton(
    buttonOnClick: () -> Unit,
    imageVector: ImageVector,
    modifier: Modifier?
) {
    Button(
        onClick = { buttonOnClick.invoke() }, modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(ButtonColor),
        colors = ButtonDefaults.buttonColors(ButtonColor)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )

    }
}

@Preview
@Composable
fun CircleButtonPreview() {
    CircleButton(buttonOnClick = { /*TODO*/ }, imageVector = Icons.Default.Star, modifier = Modifier)
}