package com.example.navigationdrawer.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String,val title: String){
    sealed class DrawerScreen(route: String,title: String,val icon: ImageVector
    ): Screen(route,title){
        object HomeScreen: DrawerScreen("HomeScreen","Home",Icons.Filled.Home)
        object NavDrawer1: DrawerScreen("NavDrawer1","Drawer1",Icons.Filled.Home)
        object NavDrawer2: DrawerScreen("NavDrawer2","Drawer2",Icons.Filled.Home)
        object NavDrawer3: DrawerScreen("NavDrawer3","Drawer3",Icons.Filled.Home)
    }
}

val screenfromDrawer = listOf(
    Screen.DrawerScreen.HomeScreen,
    Screen.DrawerScreen.NavDrawer1,
    Screen.DrawerScreen.NavDrawer2,
    Screen.DrawerScreen.NavDrawer3
)