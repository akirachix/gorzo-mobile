package com.gorzo.haba.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorzo.haba.R

val manrope = FontFamily(Font( R.font.manrope))
val kodchassan = FontFamily(Font(R.font.kodchassan))
// Set of Material typography styles to start with
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = manrope,
        fontSize = 20.sp
    ),

    titleLarge = TextStyle(
     fontFamily = kodchassan,
        fontWeight = FontWeight.Bold,
        fontSize = 44.sp
    ),
    titleMedium = TextStyle(
        fontFamily = manrope,
        fontSize = 25.sp
    ),

)