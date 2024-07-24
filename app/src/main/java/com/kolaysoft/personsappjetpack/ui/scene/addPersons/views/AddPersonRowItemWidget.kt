package com.kolaysoft.personsappjetpack.ui.scene.addPersons.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolaysoft.personsappjetpack.ui.theme.MainColor

@Composable
fun AddPersonRowItemWidget(
    imageVector: ImageVector,
    textValue: String,
    onValueChange: (String) -> Unit,
    label: @Composable() (() -> Unit)
) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,modifier = Modifier.padding(10.dp)) {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = MainColor,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        OutlinedTextField(value = textValue, onValueChange = { onValueChange.invoke(it) }, label = { label.invoke() })
    }
}

@Preview
@Composable
fun AddPersonRowItemWidgetPreview() {
    AddPersonRowItemWidget(imageVector = Icons.Default.Person, textValue = "Test", onValueChange = {}, {})
}