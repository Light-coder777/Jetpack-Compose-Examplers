package com.example.loginappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginappui.file.Login
import com.example.loginappui.file.Register
import com.example.loginappui.ui.theme.LoginAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppUITheme() {
                NavigatePage()
            }
            }
    }
}

@Composable
fun NavigatePage() {
    val navController = rememberNavController()

    NavHost(navController = navController,startDestination = "Login"){
        composable("Login",content = { Login(navController = navController)})
        composable("Register",content = { Register(navController = navController) })
    }
}