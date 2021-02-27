package com.joeys.composeWechat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.joeys.composeWechat.data.Chat
import com.joeys.composeWechat.widget.PagerState

class MainViewModel : ViewModel() {

    var selectedTab by mutableStateOf(0)
    val pagerState by mutableStateOf(PagerState())
    var chats by mutableStateOf(listOf<Chat>())

    var currentChat: Chat? by mutableStateOf(null)
    var chatting: Boolean by mutableStateOf(false)


    init {

        chats = listOf(
            Chat(R.drawable.avatar, "Joeys"),
            Chat(R.drawable.avatar, "Joeys"),
            Chat(R.drawable.avatar, "Joeys"),
            Chat(R.drawable.avatar, "Joeys")
        )
    }


    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun endChat() {
        chatting = false
    }
}