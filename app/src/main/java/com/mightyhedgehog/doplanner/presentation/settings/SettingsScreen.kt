package com.mightyhedgehog.doplanner.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.ui.compoments.settings.*
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SettingsTitle(modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp))
            SettingsSaveClickableTitle(
                modifier = Modifier.padding(end = 16.dp, top = 16.dp, bottom = 8.dp)
            )
        }
        Divider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 0.5.dp
        )
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
