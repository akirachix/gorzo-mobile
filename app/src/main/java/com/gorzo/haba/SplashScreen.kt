package com.gorzo.haba

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorzo.haba.ui.theme.HabaOrange
import kotlinx.coroutines.delay

@Composable
fun SplashScreen( onTimeout: () -> Unit){
    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }

    Box (modifier = Modifier.fillMaxSize().background(HabaOrange), contentAlignment = Alignment.Center){

        Row {
            Text(text = "HABA", color = Color.White, fontSize = 32.sp )
            Spacer(Modifier.width(10.dp))
            Text(
                text = "HABA", color = Color(0xFFFFCFFF), fontSize = 32.sp, fontWeight = FontWeight.Light
            )
        }
    }

}

@Composable
@Preview
fun SplashPreview(){
    SplashScreen(onTimeout = {})
}