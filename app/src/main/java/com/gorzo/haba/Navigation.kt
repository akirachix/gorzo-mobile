package com.gorzo.haba

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import HomeScreens.CustomerHomeScreen
import HomeScreens.VendorHomeScreen

@Composable
fun OnBoardingNavigation() {
    val navController = rememberNavController()
    var userRole by remember { mutableStateOf<String?>(null) }

    NavHost(navController = navController, startDestination = "splash") {

        composable("splash") {
            SplashScreen(onTimeout = {
                navController.navigate("roleSelection") {
                    popUpTo("splash") { inclusive = true }
                }
            })
        }

        composable("roleSelection") {
            RoleSelectionScreen(onRoleSelected = { role ->
                userRole = role
                val firstOnboardingRoute = if (role == "vendor") "vendor/welcome" else "customer/welcome"
                navController.navigate(firstOnboardingRoute) {
                    popUpTo("roleSelection") { inclusive = true }
                }
            })
        }

        // Customer onboarding flow
        composable("customer/welcome") {
            WelcomeScreenCustomer(onNext = {
                navController.navigate("customer/groupBuying")
            })
        }
        composable("customer/groupBuying") {
            GroupBuying(onNext = {
                navController.navigate("customer/howItworks")
            })
        }
        composable("customer/howItworks") {
            HowItWorks(onNext = {
                navController.navigate("customer/everybodywins")
            })
        }
        composable("customer/everybodywins") {
            EveryBodyWins(onNext = {
                navController.navigate("signup")
            })
        }

        // Vendor onboarding flow
        composable("vendor/welcome") {
            WelcomeScreen(onNext = {
                navController.navigate("vendor/inventoryManagement")
            })
        }
        composable("vendor/inventoryManagement") {
            InventoryManagement(onNext = {
                navController.navigate("vendor/orderManagement")
            })
        }
        composable("vendor/orderManagement") {
            OrderManagement(onNext = {
                navController.navigate("vendor/salesManagement")
            })
        }
        composable("vendor/salesManagement") {
            SalesManagement(onNext = {
                navController.navigate("vendor/digitalDuka")
            })
        }
        composable("vendor/digitalDuka") {
            DigitalDuka(onNext = {
                navController.navigate("signup")
            })
        }

        // Signup shared for both roles
        composable("signup") {
            SignUpScreen(
                navController = navController,
                onNext = {
                    userRole?.let { role ->
                        val route = if (role == "vendor") "vendor_home" else "customer_home"
                        navController.navigate(route) {
                            popUpTo("signup") { inclusive = true }
                        }
                    }
                }
            )
        }


        // Signin shared for both roles
        composable("signin") {
            SignIn(
                navController = navController,
                onForgetPassword = { navController.navigate("forget") },
                onSignIn = {
                    userRole?.let { role ->
                        val homeRoute = if (role == "vendor") "vendor_home" else "customer_home"
                        navController.navigate(homeRoute) {
                            popUpTo("signin") { inclusive = true }
                        }
                    }
                }
            )
        }

        // Password reset flow
        composable("forget") {
            PasswordScreen(
                onNext = { navController.navigate("otp") },
                onBack = { navController.navigate("signin") }
            )
        }
        composable("otp") {
            EnterOtpScreen(
                onNext = { navController.navigate("reset") },
                onBack = { navController.navigate("forget") }
            )
        }
        composable("reset") {
            ResetPassword(
                onNext = { navController.navigate("signin") },
                onBack = { navController.navigate("otp") }
            )
        }

        // Home Screens
        composable("customer_home") {
            CustomerHomeScreen(navController = navController)
        }

        composable("vendor_home") {
            VendorHomeScreen(navController = navController)
        }

    }
}
