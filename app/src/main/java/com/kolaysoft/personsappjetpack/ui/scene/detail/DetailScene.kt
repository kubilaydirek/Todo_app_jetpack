package com.kolaysoft.personsappjetpack.ui.scene.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kolaysoft.personsappjetpack.R
import com.kolaysoft.personsappjetpack.ui.components.ConfirmDialog
import com.kolaysoft.personsappjetpack.ui.theme.DetailScreenColor

@Composable
fun DetailScene(personId: Int, navController: NavController) {

    val viewModel: DetailSceneViewModel = hiltViewModel()
    val person by viewModel.person.collectAsState()
    val openAlertDialog = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = personId) {
        viewModel.getPersonById(personId)
    }

    if (openAlertDialog.value) {
        ConfirmDialog(
            onDismissRequest = { openAlertDialog.value = !openAlertDialog.value },
            onConfirmation = {
                viewModel.deletePersonById(personId)
                navController.popBackStack()
            },
            dialogTitle = "Are you sure you want to delete?",
            dialogText = "",
            icon = Icons.Default.Info
        )
    }

    if (person != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            PersonCardView(
                openAlertDialog = openAlertDialog,
                personFirstName = person!!.firsName,
                personLastName = person!!.lastName
            )
            PersonDetailInfoView(personPhoneNumber = person!!.phoneNumber, personAddress = person!!.address)

        }
    }
}

@Composable
fun TopBarButtons(openAlertDialog: MutableState<Boolean>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
        }
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(onClick = {
            openAlertDialog.value = !openAlertDialog.value
        }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
        }
    }
}

@Composable
fun PersonCardView(
    openAlertDialog: MutableState<Boolean>,
    personFirstName: String,
    personLastName: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .background(DetailScreenColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            TopBarButtons(openAlertDialog = openAlertDialog)
            Image(
                painter = painterResource(id = R.drawable.person_image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(0.9f)

            )
            Text(
                text = "$personFirstName $personLastName",
                style = TextStyle(fontSize = 25.sp, color = Color.White, textAlign = TextAlign.Left)
            )
        }


    }
}

@Composable
fun PersonDetailInfoView(personPhoneNumber: String, personAddress: String) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = personPhoneNumber, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        Text(text = "Phone Number", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.height(25.dp))
        Divider()
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = personAddress, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        Text(text = "Address", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.height(25.dp))
        Divider()

    }
}

@Preview
@Composable
fun DetailScenePreview() {
    val openAlertDialog = remember { mutableStateOf(false) }
    TopBarButtons(openAlertDialog = openAlertDialog)
}

@Preview
@Composable
fun PersonCardViewPreview() {
    val openAlertDialog = remember { mutableStateOf(false) }
    PersonCardView(openAlertDialog = openAlertDialog, personFirstName = "Kubilay", personLastName = "Direk")
}

@Preview
@Composable
fun PersonDetailInfoView() {
    PersonDetailInfoView(personPhoneNumber = "555-555-55-55", personAddress = "Address Info")
}