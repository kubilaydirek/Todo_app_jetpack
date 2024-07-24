package com.kolaysoft.personsappjetpack.ui.scene.addPersons.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kolaysoft.personsappjetpack.ui.theme.MainColor

@Composable
fun BottomBarButtonWidget(
    buttonText: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(50.dp)
            .background(MainColor)
            .padding(end = 5.dp)
            .clickable {
                onClick.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = buttonText, color = Color.White, fontSize = 15.sp)
    }
}

@Preview
@Composable
fun BottomBarButtonWidgetPreview() {
    BottomBarButtonWidget(buttonText = "SAVE") {}
}