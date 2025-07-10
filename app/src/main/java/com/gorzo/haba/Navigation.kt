package com.gorzo.haba
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun OnBoardingNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onTimeout = {
                navController.navigate("roleSelection") {
                    popUpTo("splash") { inclusive = true } // Clear splash from back stack
                }
            })
        }
        composable("roleSelection") {
            RoleSelectionScreen(navController = navController)
        }
        // Customer onboarding routes
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
        // Vendor onboarding routes
        composable("vendor/welcome"){
            WelcomeScreen (onNext = {
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

        composable("signup") {
            SignUpScreen(navController = navController, onNext = {
                navController.navigate("signin")
            })
        }
        composable("signin") {
            SignIn(navController = navController, onNext = {
                navController.navigate("home") {
                    popUpTo("roleSelection") { inclusive = true } // Clear onboarding from back stack
                }
            })
        }
        composable("home") {

        }
    }
}