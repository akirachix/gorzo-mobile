package com.example.haba_signup

import androidx.compose.ui.text.TextStyle

package com.example.habaapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun InputField(label:String, isPassword: Boolean = false, keyboardType:KeyboardType=KeyboardType.Text , modifier:Modifier= Modifier.fillMaxWidth().padding(vertical=4.dp)){
    var value by remember { mutableStateOf("") }
    OutlinedTextField(value=value,
        onValueChange = {value = it},
        label = { Text(label, fontSize = 12.sp) },
        textStyle = TextStyle(fontSize = 14.sp),
        singleLine= true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType= keyboardType),
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor =  Color(0xFFFF9800),
            unfocusedBorderColor = Color(0xFFFF9800)
        )
    )
}

@Composable
fun SignUp(){
    Column (modifier = Modifier.fillMaxSize().padding(25.dp, 90.dp), horizontalAlignment = Alignment.Start) {
        Text(
            text="WELCOME BACK!",
            color = Color(0xFFF57C00),
            fontSize = 40.sp
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Sign in",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold,
                color = Color(0xFFF57C00),
                fontSize = 35.sp
            )
        )

        Spacer(Modifier.height(40.dp))
//   Text (text = "First Name")
//InputField( label = "Enter Your Name")
//
//    Text (text = "Last Name")
//    InputField( label = "Enter Your Name")
        Text (text = "Phone Number")
        Spacer(modifier = Modifier.height(8.dp))
        InputField( label = "Enter Your Phone Number")
        Spacer(modifier = Modifier.height(13.dp))
        Text (text = "PIN")
        Spacer(modifier = Modifier.height(8.dp))
        InputField( label = "Enter Your Name")
//    Text (text = "Confirm PIN")
//    InputField( label = "Enter Your Name")

        Spacer(Modifier.height(40.dp))
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF57C00)), modifier = Modifier.fillMaxWidth() ){
            Text("Sign in", color = Color.White)
        }
        Spacer(Modifier.height(40.dp))


        Row (modifier = Modifier.align(Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Don't have an account?"
            )
            Text(
                text = "sign up",color = Color(0xFFF57C00),
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SignUpPreview(){
    SignUp()
}