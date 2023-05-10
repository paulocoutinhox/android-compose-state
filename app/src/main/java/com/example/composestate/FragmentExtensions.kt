package com.example.composestate

import androidx.fragment.app.Fragment

fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(this)
}