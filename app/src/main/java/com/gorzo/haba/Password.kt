

package com.gorzo.haba

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gorzo.haba.ui.theme.manrope

@Composable



fun PasswordScreen(){

    val phoneNumber = remember { mutableStateOf("") }

Column {
Text(text = "Forgot Password", fontFamily = manrope,
    style = MaterialTheme.typography.headlineLarge,fontSize = 44.sp,
fontWeight = FontWeight.Bold,
)
    Spacer(Modifier.height(5.dp))

    Text(text = "Enter Your Phone number below and we’ll send you a link to reset your password",
    fontFamily = manrope,
    )

   OutlinedTextField(
       value = phoneNumber.value,
       onValueChange = { },
       label = { Text("Enter your phone number") },

   )




}
}

@Preview
@Composable
fun ShowPassword(){
    PasswordScreen()

}