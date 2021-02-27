package com.joeys.composeWechat

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.math.roundToInt

@Composable
fun ChatPage() {
    val mainViewModel = viewModel<MainViewModel>()
    val percentOffset = animateFloatAsState(targetValue = if (mainViewModel.chatting) 0f else 1f)
    Box(
        Modifier
            .percentOffsetX(percentOffset.value)
            .background(Color.Red)
            .fillMaxSize()
    ) {


    }
}

fun Modifier.percentOffsetX(percent: Float): Modifier =
    this.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            placeable.placeRelative(
                (placeable.width.toFloat() * percent).roundToInt(),
                0
            )
        }
    }
