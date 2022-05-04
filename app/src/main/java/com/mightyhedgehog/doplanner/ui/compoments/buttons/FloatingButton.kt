package com.mightyhedgehog.doplanner.ui.compoments.buttons

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun DoPlannerFloatingButton(
    navController: NavController,
    fabState: MutableState<Boolean>
) {
    AnimatedVisibility(
        visible = fabState.value,
        enter = slideInHorizontally(initialOffsetX = { 200 }),
        exit = slideOutHorizontally(targetOffsetX = { 200 }),
    ) {
        FloatingActionButton(
            onClick = { navController.navigate(Screens.AddTaskScreen.route) },
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