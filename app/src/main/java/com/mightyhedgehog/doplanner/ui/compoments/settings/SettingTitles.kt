package com.mightyhedgehog.doplanner.ui.compoments.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun SettingsTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.settings),
        style = DoPlannerTheme.typography.dailyTitlesStyle,
        fontWeight = FontWeight.Normal
    )
}

@Composable
@Preview
fun SettingsTitlePreview() {
    DoPlannerTheme {
        Text(
            text = stringResource(id = R.string.settings),
            style = DoPlannerTheme.typography.dailyTitlesStyle,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ChangeNameTitle(modifier: Modifier = Modifier) {
    Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
        modifier = modifier,
        text = buildAnnotatedString {
            append("Change ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("name")
        })
}

@Composable
@Preview
fun ChangeNameTitlePreview(modifier: Modifier = Modifier) {
    DoPlannerTheme {
        Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
            modifier = modifier,
            text = buildAnnotatedString {
                append("Change ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
                append("name")
            })
    }
}

@Composable
fun ChangeStyleTitle(modifier: Modifier = Modifier) {
    Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
        modifier = modifier,
        text = buildAnnotatedString {
            append("Change ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("color ")
            append("scheme")
        })
}

@Composable
@Preview
fun ChangeStyleTitlePreview() {
    DoPlannerTheme {
        Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
            text = buildAnnotatedString {
                append("Change ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
                append("color ")
                append("scheme")
            })
    }
}

@Deprecated("Design changes.")
@Composable
fun SettingsSaveClickableTitle(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .clip(RoundedCornerShape(10.dp))
        .clickable { }) {
        Text(
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp),
            text = stringResource(id = R.string.save),
            style = DoPlannerTheme.typography.dailyTitlesStyle,
            color = DoPlannerTheme.colors.mainColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Deprecated("Design changes.")
@Composable
@Preview
fun SettingsSaveClickableTitlePreview() {
    DoPlannerTheme {
        Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
            Text(
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp),
                text = stringResource(id = R.string.save),
                style = DoPlannerTheme.typography.dailyTitlesStyle,
                color = DoPlannerTheme.colors.mainColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}