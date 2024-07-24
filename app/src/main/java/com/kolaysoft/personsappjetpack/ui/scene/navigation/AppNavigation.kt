package com.kolaysoft.personsappjetpack.ui.scene.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kolaysoft.personsappjetpack.ui.scene.addPersons.AddPersonsScene
import com.kolaysoft.personsappjetpack.ui.scene.detail.DetailScene
import com.kolaysoft.personsappjetpack.ui.scene.home.HomeScene

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppNavigationEnum.HOME_PAGE.name) {
        composable(AppNavigationEnum.HOME_PAGE.name) {
            HomeScene(navController)
        }
        composable(AppNavigationEnum.ADD_PERSONS.name) {
            AddPersonsScene(navController)
        }
        composable("${AppNavigationEnum.DETAIL_PAGE.name}/{personId}",
            arguments = listOf(navArgument("personId") { type = NavType.IntType })
        ) {
            val personId = it.arguments!!.getInt("personId")
            DetailScene(personId = personId, navController)
        }
    }
}