package com.mightyhedgehog.doplanner.presentation.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.mightyhedgehog.doplanner.data.local.datastore.ThemeDataStore
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerStyle
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var dataStore: ThemeDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentStyle = dataStore.getStyle.collectAsState(DoPlannerStyle.ORANGE.name)

            DoPlannerTheme(
                style = DoPlannerStyle.valueOf(currentStyle.value!!)
            ) {
                MainScreen()
            }
        }
    }
}
