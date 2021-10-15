package com.example.loginappui.file

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.loginappui.R
import com.example.loginappui.ui.theme.Greenbg
import com.example.loginappui.ui.theme.Purple700

@Composable
fun Login(
    navController: NavController
){
    var email by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()
    var password by remember { mutableStateOf("") }
    var passvisibility by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xE8CFB4EF))
            .padding(10.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xE8CFB4EF))
        ) {
            //ACC Image
            Box() {
                Image(painter = painterResource(id = R.drawable.ic_baseline_account_circle_24), contentDescription = "login")
            }

            Scaffold(
                scaffoldState = scaffoldState
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xE8CFB4EF))
                ) {
                    Text(text = "Login")
                    Spacer(modifier = Modifier.height(15.dp))
                    //For Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = {Text(text = "Email")},
                        placeholder = {Text(text = "Enter the Email")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    //For Password
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it},
                        label = {Text(text = "Password")},
                        placeholder = {Text(text = "Enter the Password(NO.S only)")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = { passvisibility = !passvisibility }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                                    contentDescription = "eye",
                                    tint = if(passvisibility) Purple700 else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if(passvisibility) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = {
                        if (email.isEmpty()) {
                            Toast.makeText(context,"Enter the email",Toast.LENGTH_SHORT).show()
                        }else if (password.isEmpty()){
                            Toast.makeText(context,"Enter the password",Toast.LENGTH_SHORT).show() 
                        }else{
                            Toast.makeText(context,"Logged successfully",Toast.LENGTH_SHORT).show()
                        }},
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)){
                        Text(text = "Sign IN")
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Don't have a account yet?")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Register Instead",modifier = Modifier.clickable {
                        navController.navigate("Register")
                    })
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefView() {
    Login(navController = rememberNavController())
}