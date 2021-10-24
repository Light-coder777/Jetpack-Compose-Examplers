package com.example.verticallist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.verticallist.response.SampleData
import com.example.verticallist.ui.theme.VerticalListTheme
import com.example.verticallist.view.SampleDetail
import com.example.verticallist.view.SampleList
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerticalListTheme {
                navigatePage()
            }
        }
    }
}

@Composable
fun navigatePage() {
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = "sample_list" ){
        composable("sample_list"){
            SampleList(navController = navController)
        }
        composable("sample_detail/{item}",
        arguments = listOf(
            navArgument("item"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry?.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, SampleData::class.java)
                SampleDetail(data = item)
            }
        }
    }
}
