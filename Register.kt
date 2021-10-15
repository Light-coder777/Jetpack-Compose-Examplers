package com.example.loginappui.file

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginappui.R
import com.example.loginappui.ui.theme.Greenbg
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.loginappui.ui.theme.Purple700

@Composable
fun Register(
    navController: NavController
) {
    //Init vars
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phoneno by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()
    var password by remember { mutableStateOf("") }
    var passvisibility by remember { mutableStateOf(false) }
    var context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Greenbg)
        .padding(10.dp)
    ){
        Column( horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Greenbg)) {

            Image(painter = painterResource(id = R.drawable.ic_baseline_account_circle_24), contentDescription = "acc")

            Scaffold(
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Greenbg)
                ) {
                    Text(text = "Register")
                    Spacer(modifier = Modifier.height(5.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
                        placeholder = { Text(text = "Enter the Email") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = {Text(text = "Name")},
                        placeholder = {Text(text = "Enter the Full Name")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    OutlinedTextField(
                        value = phoneno,
                        onValueChange = { phoneno = it },
                        label = {Text(text = "Phone NO")},
                        placeholder = {Text(text = "Enter the Phone NO")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    OutlinedTextField(
                        value = country,
                        onValueChange = { country = it },
                        label = {Text(text = "Country")},
                        placeholder = {Text(text = "Enter the Country Name")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
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

                    Button(onClick = {
                        if (email.isEmpty()) {
                            Toast.makeText(context,"Enter the email", Toast.LENGTH_SHORT).show()
                        }else if (password.isEmpty()){
                            Toast.makeText(context,"Enter the password", Toast.LENGTH_SHORT).show()
                        }else if (country.isEmpty()){
                            Toast.makeText(context,"Enter the country", Toast.LENGTH_SHORT).show()
                        }else if (name.isEmpty()){
                            Toast.makeText(context,"Enter the name", Toast.LENGTH_SHORT).show()
                        }else if (phoneno.isEmpty()){
                            Toast.makeText(context,"Enter the phone NO", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(context,"Logged successfully", Toast.LENGTH_SHORT).show()
                        }},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)){
                        Text(text = "Sign IN")
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Already have a account")
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Login Instead",modifier = Modifier.clickable {
                        navController.navigate("Login")
                    })
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefiReg() {
    Register(navController = rememberNavController())
}