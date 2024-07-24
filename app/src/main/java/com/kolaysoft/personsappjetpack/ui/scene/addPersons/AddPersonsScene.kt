package com.kolaysoft.personsappjetpack.ui.scene.addPersons

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kolaysoft.personsappjetpack.data.model.Person
import com.kolaysoft.personsappjetpack.ui.scene.addPersons.views.AddPersonRowItemWidget
import com.kolaysoft.personsappjetpack.ui.scene.addPersons.views.BottomBarButtonWidget
import com.kolaysoft.personsappjetpack.ui.theme.MainColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddPersonsScene(navController: NavController) {
    val viewModel: AddPersonsViewModel = hiltViewModel()
    val personFirstName = remember { mutableStateOf("") }
    val personLastName = remember { mutableStateOf("") }
    val personPhoneNumber = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }

    Scaffold(topBar = {
        BuildAppBar { navController.popBackStack() }
    }, content = { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp, 5.dp)
            ) {

                AddPersonRowItemWidget(imageVector = Icons.Default.Person,
                    textValue = personFirstName.value,
                    onValueChange = { personFirstName.value = it }, label = { Text(text = "First Name") })
                AddPersonRowItemWidget(imageVector = Icons.Default.Person,
                    textValue = personLastName.value,
                    onValueChange = { personLastName.value = it }, label = { Text(text = "Last Name") })

                AddPersonRowItemWidget(imageVector = Icons.Default.Phone,
                    textValue = personPhoneNumber.value,
                    onValueChange = { personPhoneNumber.value = it }, label = { Text(text = "Phone Number") })
                AddPersonRowItemWidget(imageVector = Icons.Default.AddLocation,
                    textValue = address.value,
                    onValueChange = { address.value = it }, label = { Text(text = "Address") })

            }
        }
    }, bottomBar = {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp, 10.dp, 10.dp)
        ) {
            BottomBarButtonWidget(buttonText = "CANCEL") {
                navController.popBackStack()

            }
            BottomBarButtonWidget(buttonText = "SAVE") {
                viewModel.addPerson(
                    Person(
                        firsName = personFirstName.value,
                        lastName = personLastName.value,
                        phoneNumber = personPhoneNumber.value,
                        address = address.value
                    )
                )
                navController.popBackStack()
            }

        }

    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildAppBar(
    navigationIconOnClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Add Contact", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { navigationIconOnClick.invoke() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MainColor),
    )
}

