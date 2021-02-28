package com.joeys.composeWechat

import android.util.Log

const val TAG = "joeys"
fun String?.log() {
    if (this == null)
        Log.d(TAG, "null")
    else
        this.let {
            Log.d(TAG, it)
        }
}