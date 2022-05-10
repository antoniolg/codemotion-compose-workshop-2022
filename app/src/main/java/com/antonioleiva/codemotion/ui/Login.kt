package com.antonioleiva.codemotion.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.codemotion.Screen

@Preview
@Composable
fun Login() {
    Screen {
        LoginForm(onLogin = ::onLogin)
    }
}

fun onLogin(user: String, pass: String) {
    Log.d("OnLogin", "user: $user, pass: $pass")
}

@Composable
private fun LoginForm(onLogin: (String, String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),

        ) {

        var user by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val buttonEnabled = user.isNotEmpty() && password.isNotEmpty()

        UserField(
            value = user,
            onValueChange = { user = it }
        )

        PassField(
            value = password,
            onValueChange = { password = it }
        )

        Button(
            onClick = { onLogin(user, password) },
            enabled = buttonEnabled
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
private fun PassField(value: String, onValueChange: (String) -> Unit) {
    var passVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Password") },
        visualTransformation = if (passVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passVisible = !passVisible }) {
                Icon(
                    imageVector = if (passVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null
                )
            }
        }
    )

}

@Composable
private fun UserField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("User") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

    )
}