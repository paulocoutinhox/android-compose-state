package com.example.composestate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp
import com.google.accompanist.appcompattheme.AppCompatTheme

@Composable
fun SampleComposeView(viewModel: SampleViewModel) {
    val textState by viewModel.textState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "CURRENT TIME:\n\n$textState",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}


private class FakeViewModel : PreviewParameterProvider<SampleViewModel> {
    override val values = sequenceOf(SampleViewModel())
}

@Preview
@Composable
private fun Preview(@PreviewParameter(FakeViewModel::class) viewModel: SampleViewModel) {
    AppCompatTheme {
        SampleComposeView(
            viewModel = viewModel
        )
    }
}

