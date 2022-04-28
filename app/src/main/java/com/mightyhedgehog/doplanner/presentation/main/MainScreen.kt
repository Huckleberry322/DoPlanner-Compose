package com.mightyhedgehog.doplanner.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mightyhedgehog.doplanner.app.navigation.SetupNavGraph
import com.mightyhedgehog.doplanner.ui.compoments.bars.bottombar.BottomBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
            SetupNavGraph(navController = navController)
        }
    }
}
