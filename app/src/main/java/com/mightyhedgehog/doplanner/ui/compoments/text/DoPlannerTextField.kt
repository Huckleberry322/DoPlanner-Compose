package com.mightyhedgehog.doplanner.ui.compoments.text

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.mightyhedgehog.doplanner.domain.model.user.User
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

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
@Preview
fun DoPlannerBasicTextFieldPreview() {
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