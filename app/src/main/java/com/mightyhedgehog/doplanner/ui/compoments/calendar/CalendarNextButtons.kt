package com.mightyhedgehog.doplanner.ui.compoments.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NextMonthButton(onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(DoPlannerTheme.shapes.calendarButtonShape),
        modifier = Modifier.size(35.dp),
        backgroundColor = DoPlannerTheme.colors.white,
        onClick = onClick,
        elevation = 7.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(0.4F), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.ic_next),
                tint = DoPlannerTheme.colors.black.copy(alpha = 0.9F),
                contentDescription = null
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PreviousMonthButton(onClick: () -> Unit) {
    Card(
        modifier = Modifier.size(35.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.calendarButtonShape),
        onClick = onClick,
        elevation = 7.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(0.4F), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.ic_previous),
                tint = DoPlannerTheme.colors.black.copy(alpha = 0.9F),
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview
fun MonthButtonPreview() {
    DoPlannerTheme {
        Card(
            modifier = Modifier.size(35.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(DoPlannerTheme.shapes.calendarButtonShape),
            elevation = 8.dp
        ) {
            Box(modifier = Modifier.fillMaxSize(0.3F), contentAlignment = Alignment.Center) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_next),
                    tint = DoPlannerTheme.colors.black.copy(alpha = 0.9F),
                    contentDescription = null
                )
            }
        }
    }
}