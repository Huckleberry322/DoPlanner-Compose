package com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.presentation.model.user.User
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme

@Composable
fun WelcomeBar(user: User, modifier: Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        UserImage(modifier = Modifier.size(40.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            style = DoPlannerTheme.typography.welcomeBarStyle, text = buildAnnotatedString {
                append("Hello, ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                append(user.name)
            },
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
    }
}

@Composable
@Preview
fun WelcomeBarPreview() {
    val userName = "Cody"
    DoPlannerTheme {
        Row(verticalAlignment = Alignment.CenterVertically) {
            UserImage(modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(style = DoPlannerTheme.typography.welcomeBarStyle, text = buildAnnotatedString {
                append("Hello, ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                append(userName)
            })
        }
    }
}

@Composable
fun UserImage(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.temp_avatar),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
    )
}