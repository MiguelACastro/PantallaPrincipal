package com.example.pantallaprincipal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pantallaprincipal.screens.Login
import com.example.pantallaprincipal.screens.MainScreen
import com.example.pantallaprincipal.screens.SignIn

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(

            )
        }
        composable("login") {
            Login(
                onLoginSuccess = { navController.popBackStack() }
            )
        }
        composable("signin") {
            SignIn(
                onSignInSuccess = { navController.popBackStack() }
            )
        }
    }
}
