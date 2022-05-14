package com.mightyhedgehog.doplanner.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.ui.compoments.bars.progress.OrangeDotProgressBar

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 72.dp), contentAlignment = Alignment.Center
    ) {
        OrangeDotProgressBar()
    }
}
