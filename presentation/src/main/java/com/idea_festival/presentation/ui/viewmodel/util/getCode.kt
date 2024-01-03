package com.idea_festival.presentation.ui.viewmodel.util

fun String.getCode(): String {
    return this.substringBefore(".")
}