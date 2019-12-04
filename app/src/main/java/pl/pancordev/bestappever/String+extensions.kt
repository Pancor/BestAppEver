package pl.pancordev.bestappever

import android.util.Log

fun String.log() {
    val threadName = Thread.currentThread().name
    Log.e("DEBUG", "Thread: $threadName, with message: ${this}")
}