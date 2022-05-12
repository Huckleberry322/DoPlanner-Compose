@file:OptIn(ExperimentalMaterialApi::class)

package com.mightyhedgehog.doplanner.ui.compoments.screen.settings

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun ColorSchemeBox(
    color: Color,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.size(60.dp),
        onClick = onClick,
        elevation = 10.dp,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.colorSchemeCardShape),
        backgroundColor = color
    ) {}
}

@Composable
@Preview
fun ColorSchemeBoxPreview() {
    DoPlannerTheme {
        Card(
            modifier = Modifier.size(60.dp),
            onClick = { /*TODO*/ },
            elevation = 10.dp,
            shape = RoundedCornerShape(DoPlannerTheme.shapes.colorSchemeCardShape),
            backgroundColor = DoPlannerTheme.colors.mainColor
        ) {}
    }
}
