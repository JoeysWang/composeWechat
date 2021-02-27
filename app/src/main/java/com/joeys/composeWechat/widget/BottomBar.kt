package com.joeys.composeWechat.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joeys.composeWechat.MainViewModel
import com.joeys.composeWechat.R

@Composable
fun BottomBar(selected: Int) {
    val viewModel: MainViewModel = viewModel()

    Row {
        TabItem(
            if (selected == 0) R.drawable.ic_chat else R.drawable.ic_chat_outline,
            "聊天",
            Modifier.weight(1f).clickable {
                viewModel.selectedTab = 0
            },
            if (selected == 0) MaterialTheme.colors.primary else Color.Black
        )
        TabItem(
            if (selected == 1) R.drawable.ic_people else R.drawable.ic_people_outline,
            "联系人",
            Modifier.weight(1f).clickable {
                viewModel.selectedTab = 1
            },
            if (selected == 1) MaterialTheme.colors.primary else Color.Black
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discovery else R.drawable.ic_discovery_outlined,
            "发现",
            Modifier.weight(1f).clickable {
                viewModel.selectedTab = 2
            },
            if (selected == 2) MaterialTheme.colors.primary else Color.Black
        )
        TabItem(
            if (selected == 3) R.drawable.ic_person else R.drawable.ic_person_outline,
            "我",
            Modifier.weight(1f).clickable {
                viewModel.selectedTab = 3
            },
            if (selected == 3) MaterialTheme.colors.primary else Color.Black
        )
    }
}


@Composable
fun TabItem(@DrawableRes res: Int, text: String, modifier: Modifier, tint: Color) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(res),
            text,
            modifier = Modifier.size(24.dp),
            tint = tint
        )
        Text(text, fontSize = 11.sp, color = tint)
    }
}

