package com.example.navigationdrawer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer.navigation.Drawer
import com.example.navigationdrawer.navigation.HomeScreen
import com.example.navigationdrawer.navigation.Screen
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme
import com.example.navigationdrawer.ui.theme.Purple200
import com.example.navigationdrawer.utils.Constant
import com.example.navigationdrawer.utils.Constant.title
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                NavigateDrawer()
            }
        }
    }
}

@Composable
fun NavigateDrawer() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    var topBar: @Composable () -> Unit = {
        TopAppBar(
            title = {
                Text(text = "Now is the time")
            },
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {
                    Toast.makeText(context,"YoY YoY YoY Maja", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Filled.Menu,contentDescription = null)
                }
            },
            backgroundColor = Purple200,
            elevation = AppBarDefaults.TopAppBarElevation
        )
    }

    val drawer: @Composable () -> Unit = {
        Drawer{ title, route ->
            scope.launch {
                scaffoldState.drawerState.close()
            }
            Constant.title = title
            Toast.makeText(context,title,Toast.LENGTH_SHORT).show()
            navController.navigate(route = route)
        }
    }

    Scaffold(
        topBar = {
            topBar()
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            drawer()
        },
        drawerGesturesEnabled = true
    ) { innerpadding ->
        NavigatePg(navController = navController)
    }
}

@Composable
fun NavigatePg(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.DrawerScreen.HomeScreen.route
    ){
        composable(Screen.DrawerScreen.HomeScreen.route){
            HomeScreen(value = Constant.title)
        }
    }
}
