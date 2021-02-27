package com.joeys.composeWechat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joeys.composeWechat.widget.BottomBar
import com.joeys.composeWechat.widget.ChatList
import com.joeys.composeWechat.widget.Pager

@Composable
fun HomePage() {
    val mainViewModel: MainViewModel = viewModel()
    Column() {
        val page = mainViewModel.selectedTab
        mainViewModel.pagerState.currentPage = page

        Pager(
            state = mainViewModel.pagerState,
            modifier = Modifier.weight(1f, true),
        ) {
            when (page) {
                0 -> ChatList(mainViewModel.chats)
                1 -> Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                ) {
                    Text(text = "1")
                }
                2 -> Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Cyan)
                ) {
                    Text(text = "2")
                }
                3 -> Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Yellow)
                ) {
                    Text(text = "3")
                }
            }
        }
        BottomBar(mainViewModel.selectedTab)
    }
}