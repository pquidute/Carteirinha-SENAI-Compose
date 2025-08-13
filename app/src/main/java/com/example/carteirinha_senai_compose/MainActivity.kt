package com.example.carteirinha_senai_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Size
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carteirinha_senai_compose.ui.theme.CarteirinhaSENAIComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Main(){
    val maxWidthModifier = Modifier.fillMaxWidth()
    Box(){
        Background()
    Column (
        Modifier
        .fillMaxSize()
        .padding(12.dp)
    )
    {
        Logo(maxWidthModifier.align(Alignment.CenterHorizontally).padding(30.dp))
        Name(maxWidthModifier.align(Alignment.CenterHorizontally))
        ProfilePicture(maxWidthModifier.align(Alignment.CenterHorizontally).padding(10.dp))
        QRCode(maxWidthModifier.align(Alignment.CenterHorizontally).size(200.dp))
        Box(Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(20.dp)
        )
        {
            Information(modifier = Modifier.align(Alignment.TopStart))
            Information(modifier = Modifier.align(Alignment.TopEnd))
            Information(modifier = Modifier.align(Alignment.BottomStart))
            Information(modifier = Modifier.align(Alignment.BottomEnd))
        }
    }
    }
}


@Preview
@Composable
fun Logo(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.senai_s_o_paulo_logo),
        contentDescription = "SENAI-SP Logo",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@Preview
@Composable
fun Name(modifier: Modifier = Modifier, name : String = "Undefined"){
    Text(
        name,
        fontSize = 30.sp,
        fontWeight = FontWeight.Thin,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun ProfilePicture(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.profile_icon),
        contentDescription = "Profile Picture",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding(horizontal = 50.dp)
            .size(250.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun Background(){
    Image(
        painter = painterResource(R.drawable.background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun QRCode(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.qr_code),
        contentDescription = "Profile Picture",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@Preview
@Composable
fun Information(info : String = "Data", content : String = "-", modifier: Modifier = Modifier){
    Text(
        "$info: $content",
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}


