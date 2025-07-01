package com.example.haba_signup
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haba_signup.ui.theme.HabasignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabasignupTheme {
                SignUpScreen()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {

    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val pin = remember { mutableStateOf("") }
    val confirmPin = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(Modifier.height(75.dp))

        Text(text = "Sign Up",
            style = MaterialTheme.typography.headlineLarge,fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            color = Color(0xFFFFA500),
            textAlign=TextAlign.Start,
                    )
        Spacer(Modifier.height(35.dp))



        Text(
            text = "First Name",
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )
        
        Spacer(Modifier.height(5.dp))
        OutlinedTextField(
            value = firstName.value,
            onValueChange = {firstName.value= it  },
           placeholder = { Text("Enter First Name") },
            modifier = Modifier.fillMaxWidth().height(50.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFFA500),
                unfocusedBorderColor = Color(0xFFFFA500)
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(20.dp))


        Text(
            text = "Last Name",
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(5.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {lastName.value= it  },
            placeholder = { Text("Enter Last Name") },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFFA500),
                unfocusedBorderColor = Color(0xFFFFA500)
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(20.dp))

        Text(
            text = "Phone Number",
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(5.dp))


        OutlinedTextField(
            value = "",
            onValueChange = { phoneNumber.value= it },
            placeholder = { Text("Enter Phone Number") },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFFA500),
                unfocusedBorderColor = Color(0xFFFFA500)
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(20.dp))


        Text(
            text = "Pin",
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(5.dp))


        OutlinedTextField(
            value = "",
            onValueChange = { pin.value= it },
            placeholder = { Text("Enter your pin") },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFFA500),
                unfocusedBorderColor = Color(0xFFFFA500)
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(20.dp))





        Text(
            text = "Confirm pin",
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(5.dp))


        OutlinedTextField(
            value = "",
            onValueChange = {confirmPin.value= it },
            placeholder = { Text("Confirm your pin", fontSize = 12.sp) },
            modifier = Modifier
                .fillMaxWidth().height(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFFA500),
                unfocusedBorderColor = Color(0xFFFFA500)
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(25.dp))


        Spacer(Modifier.height(26.dp))
        Button(onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F00)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(45.dp) ) {
            Text("Sign Up", fontSize = 20.sp)

        }
        Spacer(Modifier.height(20.dp))
        Text(text = buildAnnotatedString {
            append("Already have an account? ")
            withStyle(style = SpanStyle(color = Color(0xFFFFA500))) {
                append("Sign In")
                Spacer(Modifier.height(5.dp))
            }
        })
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun Register(){
    SignUpScreen()
}
