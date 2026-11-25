package com.example.pr5_kachalin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr5_kachalin.ui.screens.DetailScreen
import com.example.pr5_kachalin.ui.screens.ListScreen
class NavGraph {

}
@Composable
fun AppHavHost(navController: NavHostController)
{
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            ListScreen(navController)
        }
        composable("detail/{id}"){
            backStackEntry -> val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
            DetailScreen(id, navController)
        }
    }

}
