package com.mightyhedgehog.doplanner.ui.compoments.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun DoPlannerFloatingButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.floatingButtonShape),
        backgroundColor = DoPlannerTheme.colors.mainColor,
        contentColor = DoPlannerTheme.colors.white
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
    }
}

@Composable
@Preview
fun DoPlannerFloatingButtonPreview() {
    DoPlannerTheme {
        FloatingActionButton(
            onClick = {},
            shape = RoundedCornerShape(DoPlannerTheme.shapes.floatingButtonShape),
            backgroundColor = DoPlannerTheme.colors.mainColor,
            contentColor = DoPlannerTheme.colors.white
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
        }
    }
}