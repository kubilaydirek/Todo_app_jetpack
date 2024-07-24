package com.kolaysoft.personsappjetpack.ui.scene.home

import PersonItemWidget
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kolaysoft.personsappjetpack.ui.components.CircleButton
import com.kolaysoft.personsappjetpack.ui.scene.navigation.AppNavigationEnum
import com.kolaysoft.personsappjetpack.ui.theme.MainColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScene(navController: NavController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val personList by viewModel.data.collectAsState()

    Scaffold(topBar = {
        TopAppbarWidget()
    }, content = { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column {
                LazyColumn {
                    items(personList) { person ->
                        PersonItemWidget(person = person, navController = navController)
                    }
                }
            }
        }
    }, floatingActionButton = {
        CircleButton(
            buttonOnClick = { navController.navigate(AppNavigationEnum.ADD_PERSONS.name) },
            imageVector = Icons.Default.Add,
            modifier = Modifier
        )
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbarWidget() {
    TopAppBar(
        title = { Text("Room Database Example", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MainColor),
    )
}

