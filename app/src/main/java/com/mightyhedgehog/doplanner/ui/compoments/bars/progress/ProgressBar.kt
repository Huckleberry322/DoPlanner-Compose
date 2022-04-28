package com.mightyhedgehog.doplanner.ui.compoments.bars.progress

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun MainOrangeProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = DoPlannerTheme.colors.mainColor,
        strokeWidth = 4.dp
    )
}
