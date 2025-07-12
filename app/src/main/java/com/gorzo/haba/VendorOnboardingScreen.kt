package com.gorzo.haba

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorzo.haba.ui.theme.HabaLightOrange
import com.gorzo.haba.ui.theme.HabaOrange


@Composable
fun OnboardingScreen(
    imageRes: Int,
    heading: String,
    content: String,
    buttonText: String = "Continue",
    onNext: () -> Unit,
    showButton: Boolean = true,
    showProgressDots: Boolean = false,
    currentIndex: Int = 0,
    totalDots: Int = 0
)
{
    val kodchassan = FontFamily(Font(R.font.kodchassan))
    val manrope = FontFamily(Font(R.font.manrope))
    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(bottomStart = 150.dp, bottomEnd = 150.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(50.dp))
        Text(
            modifier = Modifier.padding(horizontal = 1.dp),
            text = heading,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = HabaOrange,
            fontFamily = kodchassan
        )
        Spacer(Modifier.height(50.dp))
        Text(
            modifier = Modifier.fillMaxWidth(0.9f),
            text = content,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = manrope
        )
        Spacer(Modifier.height(60.dp))
        if (showProgressDots && totalDots > 1) {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(totalDots) { index ->
                    val color = if (index == currentIndex) HabaOrange else HabaLightOrange
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .size(14.dp)
                            .clip(CircleShape)
                            .background(color)
                    )
                }
            }
        }
        Spacer(Modifier.height(60.dp))
        if (showButton) {
            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(HabaOrange),
                modifier = Modifier.size(200.dp, 50.dp)
            ) {
                Text(buttonText, fontSize = 20.sp, fontFamily = manrope)
            }
        }
    }
}



@Composable
fun WelcomeScreen(onNext: () -> Unit){
    OnboardingScreen(
        imageRes = R.drawable.home,
        heading = "Welcome",
        content = "Hi Mams! You're about to take your market stall online - fast, simple, and hustle-free.",
        buttonText = "Get Started",
        onNext = onNext,
        showButton = true,
        showProgressDots = false
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewWelcome() {

        WelcomeScreen( onNext = {} )
    }

@Composable
fun InventoryManagement(onNext: () -> Unit){
    OnboardingScreen(
        imageRes = R.drawable.inventory,
        heading = "Inventory Management",
        content = "  Allows to efficiently track, organize, and update stock of\n" +
                "    products.",
        buttonText = "Continue",
        onNext = onNext,
        showButton = true,
        showProgressDots = true,
        currentIndex = 0,
        totalDots = 3

    )

}

@Composable
@Preview(showBackground = true)
fun PreviewInventory() {

    InventoryManagement( onNext = {} )
}



@Composable
fun OrderManagement(onNext: () -> Unit){
    OnboardingScreen(
        imageRes = R.drawable.vegetables,
        heading = "Order Management",
        content = "  Provides vendors with a centralized platform to view, track, and manage all customer orders.",
        buttonText = "Continue",
        onNext = onNext,
        showButton = true,
        showProgressDots = true,
        currentIndex = 1,
        totalDots = 3

    )

}

@Composable
@Preview(showBackground = true)
fun PreviewOrder() {

    OrderManagement ( onNext = {} )
}

@Composable
fun SalesManagement(onNext: () -> Unit){
    OnboardingScreen(
        imageRes = R.drawable.salespage,
        heading = "Sales and Income Tracking",
        content = "  Provides vendors with sales and income tracking all customer orders.",
        buttonText = "Continue",
        onNext = onNext,
        showButton = true,
        showProgressDots = true,
        currentIndex = 2,
        totalDots = 3

    )

}

@Composable
@Preview(showBackground = true)
fun PreviewSales() {
    SalesManagement ( onNext = {} )
}


@Composable
fun DigitalDuka(onNext: () -> Unit){
    OnboardingScreen(
        imageRes = R.drawable.builddduka,
        heading = "Let’s  build your digital duka together",
        content = "Ready To sell online?",
        buttonText = "Register",
        onNext = onNext,
        showButton = true,
        showProgressDots = false
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewDigitalDuka() {

    DigitalDuka( onNext = {} )
}
