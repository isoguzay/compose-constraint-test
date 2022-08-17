package com.isoguzay.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.isoguzay.myapplication.tabs.TabsLayout

@Composable
fun IsoLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val layoutTopGuideline = createGuidelineFromTop(0.5f)

        val (bannerArea, tabsArea) = createRefs()
        Column(
            modifier = Modifier
                .background(color = Color.Gray)
                .constrainAs(bannerArea) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(layoutTopGuideline)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Test 1", color = Color.Yellow, fontSize = 17.sp)
        }

        Column(
            modifier = Modifier
                .wrapContentHeight(unbounded = true)
                .background(color = Color.Green)
                .constrainAs(tabsArea) {
                    top.linkTo(layoutTopGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            TabsLayout()
        }
    }
}