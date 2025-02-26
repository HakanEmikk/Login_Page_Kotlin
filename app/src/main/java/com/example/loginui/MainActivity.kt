package com.example.loginui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginui.ui.theme.LoginUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginUiTheme {
                Surface(color = MaterialTheme.colorScheme.background) { Greeting() }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Surface(color = MaterialTheme.colorScheme.primary) {
        val tfKullaniciAdi = remember { mutableStateOf("") }
        val tfSifre = remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = { tfKullaniciAdi.value = it },
                label = { Text(text = "Kullanıcı Adı") },
                colors = TextFieldDefaults.colors(
                    disabledLabelColor = Color.White,
                    disabledTextColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )
            TextField(
                value = tfSifre.value,
                onValueChange = { tfSifre.value = it },
                label = { Text(text = "Şifre") },
                colors = TextFieldDefaults.colors(
                    disabledLabelColor = Color.White,
                    disabledTextColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                ),
                visualTransformation = PasswordVisualTransformation(),

            )
            Button(
                onClick = { Log.e("Giriş", "Basarili") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier.size(250.dp,50.dp)
            ) {
                Text(text = "Şifre")
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginUiTheme {
        Greeting()
    }
}