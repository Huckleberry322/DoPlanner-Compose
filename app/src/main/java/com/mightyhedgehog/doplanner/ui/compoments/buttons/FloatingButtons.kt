package com.mightyhedgehog.doplanner.ui.compoments.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun DoPlannerFloatingButton(
    onClick: () -> Unit,
    fabState: MutableState<Boolean>
) {
    AnimatedVisibility(
        visible = fabState.value,
        enter = slideInHorizontally(initialOffsetX = { 200 }),
        exit = slideOutHorizontally(targetOffsetX = { 200 }),
    ) {
        FloatingActionButton(
            onClick = onClick,
            shape = RoundedCornerShape(DoPlannerTheme.shapes.floatingButtonShape),
            backgroundColor = DoPlannerTheme.colors.mainColor,
            contentColor = DoPlannerTheme.colors.white
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
        }
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

@Composable
fun PlannerFloatingButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.floatingButtonShape),
        backgroundColor = DoPlannerTheme.colors.mainColor,
        contentColor = DoPlannerTheme.colors.white
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
    }
}