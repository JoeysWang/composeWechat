package com.joeys.composeWechat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box


import com.joeys.composeWechat.ui.MyComposeTheme

class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                Box {
                    HomePage()
                    ChatPage()
                }
            }
        }
    }


    override fun onBackPressed() {
        if (mainViewModel.chatting) {
            mainViewModel.endChat()
        } else
            super.onBackPressed()
    }
}
