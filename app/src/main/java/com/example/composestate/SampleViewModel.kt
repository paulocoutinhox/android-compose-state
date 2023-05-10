package com.example.composestate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class SampleViewModel : ViewModel(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    val textState: MutableStateFlow<String?> by lazy {
        MutableStateFlow(null)
    }

    fun start() {
        viewModelScope.launch {
            while (true) {
                val currentDateTime = LocalDateTime.now().toString()

                launch(Dispatchers.IO) {
                    textState.value = currentDateTime
                }

                delay(1000)
            }
        }
    }
}