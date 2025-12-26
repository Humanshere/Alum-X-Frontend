package com.geekhaven.alumx.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.geekhaven.alumx.presentation.auth.LoginScreen
import com.geekhaven.alumx.presentation.onboarding.OnboardingScreen
import com.geekhaven.alumx.presentation.onboarding.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(onAnimationFinished = {
                navController.navigate(Screen.Onboarding.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(onGetStarted = {
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Onboarding.route) { inclusive = true }
                }
            })
        }
        composable(route = Screen.Login.route) {
            LoginScreen()
        }
    }
}
