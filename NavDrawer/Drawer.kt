package com.example.navigationdrawer.navigation

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdrawer.ui.theme.Purple500


@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onClickDestination: (route: String, title: String) -> Unit
) {

    val versionName = "1.0"
    Column(
        modifier
            .background(Purple500)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "NavDrawer",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    color = Color.White
                )
                Text(
                    text = "v $versionName",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    color = Color.White
                )
            }
        }

        Divider(color = Color.White, thickness = 1.dp)

        screenfromDrawer.forEach{ screen ->
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .clickable {
                        onClickDestination(screen.route, screen.title)
                    }
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(screen.icon, contentDescription = null,tint = Color.White)
                
                Text(
                    text = screen.title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    }
}