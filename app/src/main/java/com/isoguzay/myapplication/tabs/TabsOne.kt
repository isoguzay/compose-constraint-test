package com.isoguzay.myapplication.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TabsOne() {

    val pageList = (1..10).map { it }

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//    ) {
//        Text(text = "Ismail")
//    }

    LazyColumn(
        modifier = Modifier.height(400.dp)
    ) {
        items(count = pageList.size, itemContent = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
                    .height(50.dp)
            ) {
                Text(text = "Ismail")
            }
        })
    }
}