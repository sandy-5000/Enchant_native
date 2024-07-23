package com.wasteland.enchant.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wasteland.enchant.Home
import com.wasteland.enchant.R
import com.wasteland.enchant.SignUp
import com.wasteland.enchant.ui.theme.appBlue
import com.wasteland.enchant.utils.Player

@Composable
fun LoginContainer(nav: NavHostController, modifier: Modifier = Modifier) {
    var email by remember {
        mutableStateOf(TextFieldValue())
    }
    var password by remember {
        mutableStateOf(TextFieldValue())
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    Player()
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(0))
            .imePadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Welcome Back",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Login to your Account",
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_mail),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password, onValueChange = { password = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_lock),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                visualTransformation =
                if (showPassword) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(
                            id =
                            if (showPassword) R.drawable.icon_eye_close
                            else R.drawable.icon_eye_open,
                        ),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            showPassword = !showPassword
                        },
                    )
                },
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Didn't have an account?",
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    nav.popBackStack()
                    nav.navigate(SignUp)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    nav.navigate(Home)
                },
                colors = ButtonDefaults.buttonColors()
                    .copy(
                        containerColor = appBlue,
                        contentColor = Color.White,
                    )
            ) {
                Text(text = "Login")
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_login),
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun LoginScreen(nav: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LoginContainer(nav = nav, modifier = Modifier.padding(innerPadding))
    }
}
