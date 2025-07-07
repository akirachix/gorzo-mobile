package com.gorzo.haba
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gorzo.haba.ui.theme.HabaOrange
import com.gorzo.haba.ui.theme.kodchassan
import com.gorzo.haba.ui.theme.manrope
@Composable

fun SignUpField( label:String, isPassword: Boolean = false, keyboardType:KeyboardType=KeyboardType.Text , modifier:Modifier= Modifier.fillMaxWidth().padding(vertical=1.dp)){
    var value by remember { mutableStateOf("") }
    OutlinedTextField(value=value,
        onValueChange = {value = it},
        label = { Text(label, fontSize = 18.sp) },
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
fun SignUpScreen(navController: NavController,
                 onNext:() -> Unit,
                 ) {

    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val pin = remember { mutableStateOf("") }
    val confirmPin = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(Modifier.height(75.dp))
        Text(text = "Sign Up",
            style = MaterialTheme.typography.headlineLarge,fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
            color = HabaOrange ,
            fontFamily = kodchassan,
            textAlign=TextAlign.Start,
        )
        Spacer(Modifier.height(35.dp))


        Text (text = "First Name", fontFamily = manrope)
        Spacer(modifier = Modifier.height(0.dp))
        SignUpField( label = "Enter Your First Name", keyboardType = KeyboardType.Text)

        Spacer(modifier = Modifier.height(5.dp))
        Text (text = "Last Name", fontFamily = manrope)
        Spacer(modifier = Modifier.height(0.dp))
        SignUpField( label = "Enter Your Last Name",keyboardType = KeyboardType.Text)

        Spacer(modifier = Modifier.height(5.dp))
        Text (text = "Phone Number", fontFamily = manrope)
        Spacer(modifier = Modifier.height(0.dp))
        SignUpField( label = "Enter Your Phone Number",keyboardType = KeyboardType.Phone)

        Spacer(modifier = Modifier.height(5.dp))
        Text (text = "PIN",fontFamily = manrope)
        Spacer(modifier = Modifier.height(0.dp))
        SignUpField( label = "Enter Your Pin",keyboardType = KeyboardType.NumberPassword)

        Spacer(modifier = Modifier.height(5.dp))
        Text (text = "Confirm Pin", fontFamily = manrope)
        Spacer(modifier = Modifier.height(0.dp))
        SignUpField( label = "Confirm Your Pin",keyboardType = KeyboardType.NumberPassword)


        Spacer(Modifier.height(25.dp))


        Spacer(Modifier.height(26.dp))
        Button(onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = HabaOrange),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth() ) {
            Text("Sign Up", fontSize = 25.sp , fontFamily = manrope)
        }


        Spacer(Modifier.height(20.dp))

        ClickableText(
            text = buildAnnotatedString {
                append("Already have an account? ")
                pushStringAnnotation(tag = "SIGN_IN", annotation = "sign_in")
                withStyle(
                    style = SpanStyle(
                        color = HabaOrange,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Sign in")
                }
                pop()
            },
            modifier = Modifier
                .padding(24.dp, 16.dp, 24.dp, 0.dp)
                .fillMaxWidth(),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                fontFamily = kodchassan,
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            onClick = { offset:Int ->
                val annotatedText = buildAnnotatedString {
                    append("Already have an account? ")
                    pushStringAnnotation(tag = "SIGN_IN", annotation = "sign_in")
                    withStyle(
                        style = SpanStyle(
                            color = HabaOrange,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Sign in")
                    }
                    pop()
                }
                annotatedText.getStringAnnotations(tag = "SIGN_IN", start = offset, end = offset)
                    .firstOrNull()?.let {
                        navController.navigate("signin")
                    }

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Register(){
    val previewNavController = rememberNavController()
    SignUpScreen(navController = previewNavController, onNext = {})
}






@Composable

fun InputField( label:String, isPassword: Boolean = false, keyboardType:KeyboardType=KeyboardType.Text , modifier:Modifier= Modifier.fillMaxWidth().padding(vertical=4.dp)){
    var value by remember { mutableStateOf("") }
    OutlinedTextField(value=value,
        onValueChange = {value = it},
        label = { Text(label, fontSize = 18.sp) },
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
fun SignIn(navController: NavController,
           onNext: () -> Unit){
    Column (modifier = Modifier.fillMaxSize().padding(25.dp, 90.dp), horizontalAlignment = Alignment.Start) {
        Text(
            text="WELCOME BACK!",
            color = Color(0xFFF57C00),
            fontSize = 40.sp,
            fontFamily = manrope,
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Sign in",
            fontFamily = kodchassan,
           fontWeight = FontWeight.Bold,
                color = Color(0xFFF57C00),
                fontSize = 44.sp
            )


        Spacer(Modifier.height(40.dp))
        Text (text = "Phone Number", fontFamily = manrope)
        Spacer(modifier = Modifier.height(8.dp))
        InputField( label = "Enter Your Phone Number",keyboardType = KeyboardType.Phone)
        Spacer(modifier = Modifier.height(13.dp))
        Text (text = "PIN", fontFamily = manrope)
        Spacer(modifier = Modifier.height(8.dp))
        InputField( label = "Enter Your Pin",keyboardType = KeyboardType.NumberPassword)

        Spacer(Modifier.height(40.dp))
        Button(onClick = {},  shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF57C00)), modifier = Modifier.fillMaxWidth() ){

            Text("Sign in", color = Color.White , fontFamily = manrope, fontSize = 25.sp)
        }
        Spacer(Modifier.height(40.dp))


        ClickableText(
            text = buildAnnotatedString {
                append("Dont have an account? ")
                pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
                withStyle(
                    style = SpanStyle(
                        color = HabaOrange,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Sign up")
                }
                pop()
            },
            modifier = Modifier
                .padding(24.dp, 16.dp, 24.dp, 0.dp)
                .fillMaxWidth(),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                fontFamily = kodchassan,
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            onClick = { offset:Int ->
                val annotatedText = buildAnnotatedString {
                    append("Don't have an account? ")
                    pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
                    withStyle(
                        style = SpanStyle(
                            color = HabaOrange,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Sign up")
                    }
                    pop()
                }
                annotatedText.getStringAnnotations(tag = "SIGN_UP", start = offset, end = offset)
                    .firstOrNull()?.let {
                        navController.navigate("signup")
                    }
        }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    val previewNavController = rememberNavController()
    SignIn(navController = previewNavController,onNext = {})
}