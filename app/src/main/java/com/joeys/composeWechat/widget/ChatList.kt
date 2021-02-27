package com.joeys.composeWechat.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joeys.composeWechat.MainViewModel
import com.joeys.composeWechat.data.Chat

@Composable
fun ChatList(chats: List<Chat>) {
    val mainViewModel: MainViewModel = viewModel()

    LazyColumn(Modifier.fillMaxSize()) {
        itemsIndexed(chats) { index, chat ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        mainViewModel.startChat(chat)
                    }) {
                Image(
                    painter = painterResource(id = chat.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(68.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = chat.name,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = chat.message,
                        maxLines = 2,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
            if (index < chats.size - 1)
                Divider(
                    color = Color.LightGray,
                    thickness = 0.8f.dp,
                    startIndent = 68.dp,
                    modifier = Modifier.padding(end = 8.dp)
                )
        }
    }
}