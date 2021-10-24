package com.example.verticallist.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.verticallist.R
import com.example.verticallist.response.SampleData
import com.example.verticallist.ui.theme.Purple700
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun SampleList(navController: NavController) {
    val context = LocalContext.current
    val dataFileString =  getdatafromasset(context,"SampleData.json")
    val gson = Gson()
    val listSampleList = object : TypeToken<List<SampleData>>() {}.type
    var sampleData: List<SampleData> = gson.fromJson(dataFileString, listSampleList)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .width(50.dp)
                .background(Purple700),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "YoY List is in the way bro")
        }

        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
        ){
            items(sampleData){ data ->
                SampleDataListItem(data,navController)
            }
        }
    }
}

@Composable
fun SampleDataListItem(data: SampleData, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                val itemval = Gson().toJson(data)
                navController.navigate("sample_detail/${itemval}")
            }
            .padding(10.dp)
            .fillMaxSize(),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.qr_code),
                contentDescription = "tp",
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = data.name,fontSize = 15.sp ,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = data.desc, fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}

fun getdatafromasset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}


@Preview(showBackground = true)
@Composable
private fun Def() {
    SampleList(navController = rememberNavController())
}

