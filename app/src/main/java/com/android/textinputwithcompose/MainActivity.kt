package com.android.textinputwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.android.textinputwithcompose.ui.theme.TextInputWithComposeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTextInput()
        }
    }
}

@Composable
fun MyTextInput() {
    Column() {
        Text(text = "Basic Text Field")
        var basicText by remember{ mutableStateOf("")}
        BasicTextField(
            value = basicText, 
            onValueChange = {basicText = it},
            modifier = Modifier.padding(8.dp)
        )

        Text(text = "Text Field")
        var tfText by remember{ mutableStateOf("")}
        TextField(value = tfText, onValueChange = {tfText = it})

        Text(text = "Outline Text Field")
        var otfText by remember{ mutableStateOf("")}
        OutlinedTextField(value = otfText, onValueChange = {otfText = it}, label = { Text(text = ("Outlined"))})

        Text(text = "Outline Text Field With keyboard options")
        var otfTextKey by remember{ mutableStateOf("")}
        OutlinedTextField(value = otfTextKey, onValueChange = {otfTextKey = it}, label = { Text(text = ("Outlined"))}, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
    }
}
