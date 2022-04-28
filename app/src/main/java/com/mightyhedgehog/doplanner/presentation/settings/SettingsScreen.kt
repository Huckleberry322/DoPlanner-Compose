package com.mightyhedgehog.doplanner.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.ui.compoments.settings.ChangeNameTitle
import com.mightyhedgehog.doplanner.ui.compoments.settings.ChangeStyleTitle
import com.mightyhedgehog.doplanner.ui.compoments.settings.ColorSchemeBox
import com.mightyhedgehog.doplanner.ui.theme.*
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerStyle

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
                vm.changeSchemeClicked(DoPlannerStyle.ORANGE)
            })
            ColorSchemeBox(color = blueLightPalette.mainColor, onClick = {
                vm.changeSchemeClicked(DoPlannerStyle.BLUE)
            })
            ColorSchemeBox(color = pinkLightPalette.mainColor, onClick = {
                vm.changeSchemeClicked(DoPlannerStyle.PINK)
            })
        }
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorSchemeBox(color = purpleLightPalette.mainColor, onClick = {
                vm.changeSchemeClicked(DoPlannerStyle.PURPLE)
            })
            ColorSchemeBox(color = greenLightPalette.mainColor, onClick = {
                vm.changeSchemeClicked(DoPlannerStyle.GREEN)
            })
        }
    }
}
