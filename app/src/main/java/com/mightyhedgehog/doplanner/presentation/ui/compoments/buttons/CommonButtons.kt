package com.mightyhedgehog.doplanner.presentation.ui.compoments.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme

@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier.size(30.dp),
            painter = icon,
            tint = DoPlannerTheme.colors.black.copy(alpha = 0.9F),
            contentDescription = null
        )
    }
}

@Composable
@Preview
fun NavigationButtonPreview() {
    DoPlannerTheme {
        Box(
            modifier = Modifier.size(35.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_next),
                tint = DoPlannerTheme.colors.black.copy(alpha = 0.9F),
                contentDescription = null
            )
        }
    }
}

@Composable
fun DoPlannerBasicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textRes: Int,
    enabled: Boolean = true,
    buttonColor: Color = DoPlannerTheme.colors.mainColor,
    buttonTextColor: Color = DoPlannerTheme.colors.mainColor,
    buttonTextStyle: TextStyle = DoPlannerTheme.typography.dailyTitlesStyle,
) {
    val borderColor = if (enabled) {
        buttonColor
    } else {
        DoPlannerTheme.colors.black.copy(alpha = 0.2F)
    }

    val textColor = if (enabled) {
        buttonTextColor
    } else {
        DoPlannerTheme.colors.black.copy(alpha = 0.2F)
    }

    OutlinedButton(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
        onClick = onClick,
        border = BorderStroke(
            width = 1.5.dp,
            color = borderColor
        ),
        contentPadding = PaddingValues(8.dp),
        shape = RoundedCornerShape(14.dp),
        enabled = enabled,
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            text = stringResource(id = textRes),
            style = buttonTextStyle,
            color = textColor,
        )
    }
}

@Composable
@Preview
fun DoPlannerBasicButtonPreview() {
    DoPlannerTheme {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, DoPlannerTheme.colors.mainColor),
            contentPadding = PaddingValues(8.dp),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = "Basic Button",
                style = DoPlannerTheme.typography.dailyTitlesStyle,
                color = DoPlannerTheme.colors.mainColor
            )
        }
    }
}
