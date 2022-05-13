package com.mightyhedgehog.doplanner.presentation.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.Text
import com.mightyhedgehog.doplanner.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mightyhedgehog.doplanner.ui.compoments.buttons.DoPlannerBasicButton
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun SimpleDoPlannerChoseDialog(
    modifier: Modifier = Modifier,
    action: () -> Unit,
    onDismiss: () -> Unit,
    titleRes: Int,
    positiveAnswerRes: Int,
    negativeAnswerRes: Int,
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(IntrinsicSize.Min)
                .background(
                    color = DoPlannerTheme.colors.backgroundWhite,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = titleRes),
                    style = DoPlannerTheme.typography.dialogStyle
                )
                Divider(
                    modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
                    thickness = 1.dp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    DoPlannerBasicButton(
                        onClick = { onDismiss() },
                        textRes = negativeAnswerRes,
                        buttonColor = Color.Transparent,
                        buttonTextColor = DoPlannerTheme.colors.black,
                        buttonTextStyle = DoPlannerTheme.typography.dialogStyle
                    )
                    DoPlannerBasicButton(
                        onClick = { action() },
                        textRes = positiveAnswerRes,
                        buttonTextStyle = DoPlannerTheme.typography.dialogStyle
                    )
                }
            }
        }
    }
}
