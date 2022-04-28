package com.mightyhedgehog.doplanner.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.domain.model.settings.SettingsBundle
import com.mightyhedgehog.doplanner.ui.compoments.settings.ChangeNameTitle
import com.mightyhedgehog.doplanner.ui.compoments.settings.ChangeStyleTitle
import com.mightyhedgehog.doplanner.ui.compoments.settings.ColorSchemeBox
import com.mightyhedgehog.doplanner.ui.theme.*

@Composable
fun SettingsScreen(
    vm: SettingsScreenViewModel,
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .background(DoPlannerTheme.colors.backgroundWhite)
            .fillMaxSize()
    ) {
        ChangeNameTitle(modifier = Modifier.padding(16.dp))
        ChangeStyleTitle(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorSchemeBox(color = orangeLightPalette.mainColor, onClick = {
            })
            ColorSchemeBox(color = blueLightPalette.mainColor, onClick = {
            })
            ColorSchemeBox(color = pinkLightPalette.mainColor, onClick = {
            })
        }
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorSchemeBox(color = purpleLightPalette.mainColor, onClick = {
            })
            ColorSchemeBox(color = greenLightPalette.mainColor, onClick = {
            })
        }
    }
}
