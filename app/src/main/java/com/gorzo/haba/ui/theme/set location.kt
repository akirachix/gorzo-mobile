package com.gorzo.haba.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable



@Composable

fun SetLocation(){
    Column {
        Text("Allow “Haba” to access your location?\n" +
                "Sharing  your location  allows Haba to\n" +
                " provide nearby vendors.")
    }

}