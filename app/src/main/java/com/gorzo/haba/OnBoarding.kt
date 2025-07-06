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
import com.gorzo.haba.ui.theme.HabaLightOrange
import com.gorzo.haba.ui.theme.HabaOrange
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SplashScreen( onTimeout: () -> Unit){
    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }

    Box (modifier = Modifier.fillMaxSize().background(HabaOrange), contentAlignment = Alignment.Center){

        Row {
            Text(text = "HABA", color = Color.White, fontSize = 32.sp)
            Spacer(Modifier.width(10.dp))
            Text(
                text = "HABA", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Thin
            )
        }
    }

}

//@Composable
//@Preview
//fun SplashPreview(){
//    SplashScreen(onTimeout = {})
//}

@Composable
fun WelcomeScreen(onNext:() -> Unit){
    val  kodchassan = FontFamily(Font(R.font.kodchassan))
    val manrope = FontFamily(Font(R.font.manrope))
    Column (
        modifier = Modifier.fillMaxSize().padding(horizontal = 1.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.vegetables),
            contentDescription = "Welcome Image"
            , modifier = Modifier.clip(RoundedCornerShape(200.dp))
        )
        Spacer(Modifier.height(100.dp))
        Text(
            text = "Welcome",
            fontWeight = FontWeight.Bold,
            fontSize = 44.sp, color = HabaOrange,
            fontFamily = kodchassan
        )
        Spacer(Modifier.height(50.dp))
        Text(

            text = "Buy fresh groceries from local" +
                    " mama mboga - at better prices, with your neighbors!", textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontFamily = manrope

        )
        Spacer(Modifier.height(70.dp))
        Button(onClick = onNext, colors =ButtonDefaults.buttonColors(HabaOrange) , modifier = Modifier.size(200.dp , 50.dp) ){
            Text("Get Started" , fontSize = 20.sp,     fontFamily = manrope)
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun PreviewWelcome(){
// WelcomeScreen(onNext = {})
//}


@Composable
fun GroupBuying(onNext:() -> Unit){
    val  kodchassan = FontFamily(Font(R.font.kodchassan))
    val manrope = FontFamily(Font(R.font.manrope))
    Column (
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.groupbuying
        ),
            contentDescription = "Group Buying Image"
            , modifier = Modifier.fillMaxWidth().height(300.dp).clip(RoundedCornerShape(0.dp , 0.dp, 150.dp , 150.dp))
        )
        Spacer(Modifier.height(70.dp))
        Text(
            text = "Group Buying",
            fontWeight = FontWeight.Bold,
            fontSize = 44.sp, color = HabaOrange,
            fontFamily = kodchassan
        )
        Spacer(Modifier.height(50.dp))
        Text(

            text = "Instead of buying alone, you join a group  with others nearby.\n" +
                    "The more the people , the better the price.", textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontFamily = manrope

        )

        Spacer(Modifier.height(50.dp))
        Row {
            Box(
                modifier = Modifier
                    .size(17.dp).
                    clip(CircleShape)
                    .background(HabaOrange)
            )


            Spacer(Modifier.width(20.dp))

            Box(
                modifier = Modifier.size(17.dp).clip(CircleShape).background(HabaLightOrange)
            )
        }
        Spacer(Modifier.height(50.dp))
        Button(onClick = onNext, colors =ButtonDefaults.buttonColors(HabaOrange) , modifier = Modifier.size(200.dp , 50.dp) ){
            Text("Continue" , fontSize = 20.sp,     fontFamily = manrope)
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun PreviewGroupBuying(){
//    GroupBuying(onNext = {})
//}



@Composable
fun HowItWorks(onNext:() -> Unit){
    val  kodchassan = FontFamily(Font(R.font.kodchassan))
    val manrope = FontFamily(Font(R.font.manrope))
    Column (
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.howitwork
            ),
            contentDescription = "How it works Image",
            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 180.dp, bottomEnd = 180.dp))
                .fillMaxWidth()
                .height(300.dp), contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(70.dp))
        Text(
            text = "How It Works",
            fontWeight = FontWeight.Bold,
            fontSize = 44.sp, color = HabaOrange,
            fontFamily = kodchassan
        )
        Spacer(Modifier.height(50.dp))

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 55.dp), horizontalAlignment = Alignment.Start) {
            Row(modifier = Modifier.padding(horizontal = 0.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.rocket),
                    contentDescription = "Rocket",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = "Launch or Join a Group", fontSize = 20.sp,
                    fontFamily = manrope
                )

            }
            Spacer(Modifier.height(10.dp))
            Row(modifier = Modifier.padding(horizontal = 0.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "Rocket",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = "Share with Friends", fontSize = 20.sp,
                    fontFamily = manrope
                )
            }
            Spacer(Modifier.height(10.dp))
            Row(modifier = Modifier.padding(horizontal = 0.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.target),
                    contentDescription = "Rocket",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = "Reach Target", fontSize = 20.sp,    fontFamily = manrope
                )
            }
            Spacer(Modifier.height(10.dp))
            Row(modifier = Modifier.padding(horizontal = 0.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.palm),
                    contentDescription = "Rocket",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(Modifier.width(17.dp))
                Text(
                    text = "Enjoy  Wholesale", fontSize = 20.sp, fontFamily = manrope
                )
            }
        }
        Spacer(Modifier.height(45.dp))
        Row {
            Box(
                modifier = Modifier
                    .size(17.dp).
                    clip(CircleShape)
                    .background(HabaLightOrange)
            )


            Spacer(Modifier.width(20.dp))

            Box(
                modifier = Modifier.size(17.dp).clip(CircleShape).background(HabaOrange)
            )
        }
        Spacer(Modifier.height(45.dp))
        Button(onClick = onNext, colors =ButtonDefaults.buttonColors(HabaOrange) , modifier = Modifier.size(200.dp , 50.dp) ){
            Text("Continue" , fontSize = 20.sp,     fontFamily = manrope)
        }


    }
}

//
//@Composable
//@Preview(showBackground = true)
//fun PreviewHowItWorks(){
//
//    HowItWorks(onNext = {})
//}


@Composable
fun EveryBodyWins(onNext:() -> Unit){
    val  kodchassan = FontFamily(Font(R.font.kodchassan))
    val manrope = FontFamily(Font(R.font.manrope))
    Column (
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.everybodyf),
            contentDescription = "Everybody Wins"
            , modifier = Modifier.clip(RoundedCornerShape(0.dp ,0.dp, 170.dp , 170.dp )).fillMaxWidth(), contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(100.dp))
        Text(
            text = "Everybody Wins",
            fontWeight = FontWeight.Bold,
            fontSize = 44.sp, color = HabaOrange,
            fontFamily = kodchassan
        )
        Spacer(Modifier.height(50.dp))
        Text(

            text ="Lower prices for you\n" +
                    "Higher  sales for mama mboga\n" +
                    "Less food waste, more community", textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontFamily = manrope

        )
        Spacer(Modifier.height(70.dp))
        Button(onClick = onNext, colors =ButtonDefaults.buttonColors(HabaOrange) , modifier = Modifier.size(200.dp , 50.dp) ){
            Text("Register" , fontSize = 20.sp,     fontFamily = manrope)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewEverybodywins(){

    EveryBodyWins(onNext = {})
}



