package com.mightyhedgehog.doplanner.ui.compoments.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

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
fun ChangeNameTitlePreview(modifier: Modifier = Modifier) {
    Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
        modifier = modifier,
        text = buildAnnotatedString {
            append("Change ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("name")
        })
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
