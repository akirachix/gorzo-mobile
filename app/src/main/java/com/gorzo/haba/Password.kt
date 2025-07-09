

package com.gorzo.haba

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Label
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Style
import com.gorzo.haba.ui.theme.HabaOrange
import com.gorzo.haba.ui.theme.manrope

@Composable
fun PasswordScreen(onNext: () -> Unit,onBack: () -> Unit){

    val phoneNumber = remember { mutableStateOf("") }


Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 20.dp, horizontal = 20.dp),
    verticalArrangement = Arrangement.Top


) {
    IconButton(
        onClick =onBack ,
        modifier = Modifier.align(Alignment.Start)
            .padding(top = 16.dp)
    ) {
        Icon(

            painterResource(id = R.drawable.outline_arrow_circle_left_24 ), contentDescription = "Back",  tint = HabaOrange,   modifier = Modifier.size(120.dp))

    }

Text(text = "Forgot Password", fontFamily = manrope,
    style = MaterialTheme.typography.headlineLarge,fontSize = 35.sp,
fontWeight = FontWeight.Bold,
    modifier = Modifier .padding(top = 30.dp, ).padding(horizontal = 20.dp)
)
    Spacer(Modifier.height(25.dp))

    Text(text = "Enter Your Phone number below and we’ll send you a link to reset your password",
    fontFamily = manrope,
        modifier = Modifier.padding(horizontal = 10.dp)
    )
    Spacer(Modifier.height(50.dp))

    InputField( label = "Enter your phone number",keyboardType = KeyboardType.NumberPassword,
        modifier = Modifier.padding(horizontal = 40.dp).width(300.dp))


    Spacer(Modifier.height(30.dp))
    Button(onClick = onNext,
        colors = ButtonDefaults.buttonColors(containerColor = HabaOrange),
        modifier = Modifier.padding(horizontal = 40.dp).width(290.dp),
        shape = RoundedCornerShape(8.dp),
    )
    {
Text("Send", fontSize = 25.sp, fontFamily = manrope)
    }
}
}

@Preview(showBackground = true)
@Composable
fun ChangePassword(){
    PasswordScreen(onNext = {}, onBack = {})

}

@Composable
fun OtpUnderlineInput(otp: SnapshotStateList<String>, otpLength: Int = 6) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        for (i in 0 until otpLength) {
            BasicTextField(
                value = otp[i],
                onValueChange = {
                    if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                        otp[i] = it
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle =TextStyle(
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Column(
                        modifier = Modifier
                            .width(40.dp)
                            .height(48.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        innerTextField()
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(Color.Black)
                        )
                    }
                }
            )
        }
    }
}


@Composable
fun EnterOtpScreen(onNext: () -> Unit,onBack: () -> Unit) {
    val otpLength = 6
    val otp = remember{ mutableStateListOf("", "", "", "", "", "") }
    Column(
        modifier = Modifier
            .fillMaxSize(),


        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Color(0xFFFF6B00))
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp).padding(top = 20.dp)
                ) {
                    Icon(

                        painterResource(id = R.drawable.outline_arrow_circle_left_24 ), contentDescription = "Back",  tint = Color.White,   modifier = Modifier.size(120.dp))

                }
                Text(
                    text = "Enter Your OTP",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.kodchassan)),
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 42.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.twotone_add_photo_alternate_24),
                    contentDescription ="MOBILE",
                    tint = Color.White,
                    modifier = Modifier
                        .size(90.dp)
                        .align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 210.dp )
                    .padding(horizontal = 20.dp )
                    .background(Color.White, shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("We've sent OTP on your number", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(16.dp))
                OtpUnderlineInput(otp= otp)
                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = onNext,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(start = 15.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B00))
                )

                {
                    Text("Verify", color = Color.White)
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row {
                    Text("Didn't Receive a OTP?")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "Resend OTP",
                        color = Color(0xFFFF6B00),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { /* Handle resend */ }
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))



            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnterOtpPreview(){

    EnterOtpScreen(onNext = {}, onBack = {})
}




@Composable
fun ResetPassword(onNext: () -> Unit,onBack: () -> Unit) {

    val password = remember { mutableStateOf("") }
    val confirm = remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Top


    ) {

        IconButton(
            onClick = onBack,
            modifier = Modifier.align(Alignment.Start)
                .padding(top = 16.dp)
        ) {
            Icon(

                painterResource(id = R.drawable.outline_arrow_circle_left_24 ), contentDescription = "Back",  tint = HabaOrange,   modifier = Modifier.size(120.dp))

        }
        Text(
            text = "Reset Password", fontFamily = manrope,
            style = MaterialTheme.typography.headlineLarge, fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 30.dp,).padding(horizontal = 45.dp)
        )
        Spacer(Modifier.height(45.dp))

        Text(" Password", fontFamily = manrope, modifier = Modifier.padding(start = 45.dp))
        InputField( label = "Enter your password",keyboardType = KeyboardType.NumberPassword,
            modifier = Modifier.padding(horizontal = 40.dp).width(300.dp))
        Spacer(Modifier.height(40.dp))

        Text("Confirm  Password",fontFamily = manrope,modifier = Modifier.padding(start = 45.dp))
        InputField( label = "Confirm your password",keyboardType = KeyboardType.NumberPassword,
            modifier = Modifier.padding(horizontal = 40.dp).width(300.dp))
        Spacer(Modifier.height(45.dp))

        Button(
            onClick = onNext,
            colors = ButtonDefaults.buttonColors(containerColor = HabaOrange),
            modifier = Modifier.padding(horizontal = 40.dp).width(290.dp),
            shape = RoundedCornerShape(8.dp),
        )
        {
            Text("Reset password", fontSize = 25.sp, fontFamily = manrope)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmResetPassword(){
     ResetPassword(onNext = {}, onBack = {})
}


