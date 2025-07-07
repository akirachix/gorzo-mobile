package com.gorzo.haba
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gorzo.haba.EveryBodyWins
import com.gorzo.haba.GroupBuying
import com.gorzo.haba.HowItWorks
import com.gorzo.haba.SplashScreen
import com.gorzo.haba.WelcomeScreen



@Composable
fun OnBoardingNavigation(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "splash"){
        composable("splash"){
            SplashScreen  (onTimeout = {
                navController.navigate("welcome") })
        }
        composable("welcome"){
            WelcomeScreen (onNext = {
                navController.navigate(("groupBuying") )})
        }
        composable("groupBuying"){
            GroupBuying(onNext =  { navController.navigate(("howItworks")) })
        }
        composable("howItworks"){
            HowItWorks (onNext = {  navController.navigate(("everybodywins"))})
        }
        composable("everybodywins"){
            EveryBodyWins (onNext = {  navController.navigate("signup")})

        }
        composable("signup"){
            SignUpScreen (navController = navController, onNext = { navController.navigate ("signin")})

        }
        composable("signin"){
            SignIn(navController = navController, onNext = { navController.navigate ("home")})
        }
    }
}
