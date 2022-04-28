package com.mightyhedgehog.doplanner.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerStyle
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentStyle = remember { mutableStateOf(DoPlannerStyle.ORANGE) }

            DoPlannerTheme(
                style = currentStyle.value
            ) {
                MainScreen()
            }
        }
    }
}
