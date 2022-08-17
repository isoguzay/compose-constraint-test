package com.isoguzay.myapplication.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsLayout() {

    val pageList = (1..3).map { it }

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    // FIXME : remove static height
    Column(modifier = Modifier.height(500.dp)) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                )
            }
        ) {
            pageList.forEachIndexed { index, item ->
                Tab(
                    modifier = Modifier, text = {
                        Row() {
                            Text(
                                text = pageList[index].toString(),
                                fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            count = pageList.size,
            state = pagerState,
        ) { page ->
            when (pageList[page]) {
                1 -> TabsOne()
                2 -> TabsTwo()
                3 -> TabsThree()
            }
        }

    }
}