package com.isoguzay.myapplication.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TabsThree() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Text(text = "Ay")
    }
}