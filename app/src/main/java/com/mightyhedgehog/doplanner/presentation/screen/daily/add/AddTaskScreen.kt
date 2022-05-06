package com.mightyhedgehog.doplanner.presentation.screen.daily.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun AddTaskScreen(vm: AddTaskScreenViewModel, navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DoPlannerTheme.colors.backgroundWhite))
}
