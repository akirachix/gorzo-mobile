package com.gorzo.haba

import android.text.Layout
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gorzo.haba.ui.theme.HabaLightOrange
import com.gorzo.haba.ui.theme.HabaOrange
import com.gorzo.haba.ui.theme.kodchassan

@Composable
fun BottomWave(modifier: Modifier = Modifier, color: Color = HabaOrange) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(0f, height * 0.5f)
            quadraticBezierTo(
                width * 0.25f, height,
                width * 0.5f, height * 0.5f
            )
            quadraticBezierTo(
                width * 0.75f, 0f,
                width, height * 0.5f
            )
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path, color = color)
    }
}

@Composable
fun RoleSelectionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logohaba),
            contentDescription = "Haba Logo",
            modifier = Modifier
                .padding(vertical = 65.dp)
                .height(80.dp)
        )
        Spacer(Modifier.padding(vertical = 20.dp))
        Text(
            text = "Welcome to Haba!",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = kodchassan,
            color = HabaOrange
        )
        Spacer(Modifier.padding(vertical = 30.dp))
        Text(
            text = "Please choose your role to continue",
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )
        Button(
            onClick = {
                navController.navigate("customer/welcome")
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = HabaOrange),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(vertical = 8.dp, horizontal = 24.dp)
        ) {
            Text(text = "I'm a Customer")
        }
        Button(
            onClick = {
                navController.navigate("vendor/welcome")
            },

            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = HabaLightOrange),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(vertical = 8.dp, horizontal = 24.dp)
        ) {
            Text(text = "I'm a Vendor", color = HabaOrange)
        }
        Spacer(Modifier.padding(vertical = 135.dp))
        BottomWave()
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewRole(){
    val navController = rememberNavController()
    RoleSelectionScreen(navController = navController)

}
