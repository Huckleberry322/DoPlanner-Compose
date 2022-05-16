package com.mightyhedgehog.doplanner.presentation.ui.compoments.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.presentation.model.user.User
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme

@Composable
fun ChangeUserNameTextField(
    modifier: Modifier = Modifier,
    user: User,
    saveUserName: (String) -> Unit,
) {

    DoPlannerBasicTextFieldWithDoneIme(
        modifier = modifier,
        text = user.name,
        returnedValue = saveUserName
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DoPlannerBasicTextFieldWithDoneIme(
    modifier: Modifier = Modifier,
    text: String,
    returnedValue: (String) -> Unit,
) {
    var currentText by remember { mutableStateOf(text) }

    val kc = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier,
        value = currentText,
        onValueChange = { currentText = it },
        singleLine = true,
        textStyle = DoPlannerTheme.typography.dailyTitlesStyle,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                kc?.hide()
                focusManager.clearFocus()
                returnedValue(currentText)
            },
        ),
    )
}

@Composable
fun DoPlannerBasicFieldField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged:(String) -> Unit,
    paddingTop: Dp,
    dividerThickness: Dp,
    hintRes: Int,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    ) {
    Column {
        BasicTextField(
            modifier = modifier.padding(top = paddingTop),
            readOnly = readOnly,
            value = text,
            onValueChange = onValueChanged,
            singleLine = true,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = stringResource(id = hintRes),
                            color = DoPlannerTheme.colors.black.copy(alpha = 0.2F),
                        )
                    }
                    innerTextField()
                }
            }
        )
        Divider(
            modifier = modifier.padding(top = 8.dp),
            thickness = dividerThickness
        )
    }
}

@Composable
@Preview
fun DoPlannerOutlineTextFieldPreview() {
    DoPlannerTheme {
        val text = "Sir Cody III"

        OutlinedTextField(
            value = text,
            onValueChange = { },
            singleLine = true,
            textStyle = DoPlannerTheme.typography.dailyTitlesStyle,
        )
    }
}

@Composable
@Preview
fun DoPlannerBasicTextFieldPreview() {
    DoPlannerTheme {
        Column {
            var currentText by remember { mutableStateOf("") }

            BasicTextField(
                value = currentText,
                onValueChange = { currentText = it },
                singleLine = true,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        if (currentText.isEmpty()) {
                            Text(
                                text = stringResource(id = R.string.title_hint),
                                color = DoPlannerTheme.colors.black.copy(alpha = 0.2F),
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Divider(
                modifier = Modifier.padding(top = 8.dp),
                thickness = 0.5.dp
            )
        }
    }
}
