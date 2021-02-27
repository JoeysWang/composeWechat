package com.joeys.composeWechat.data

import androidx.annotation.DrawableRes

data class Chat(
    @DrawableRes val image: Int,
    val name: String,
    val message: String = "Jetpack Compose is the modern toolkit for building native Android UI. Here's where you'll find the latest information about using Compose.\n"
) {
}