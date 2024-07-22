package com.wasteland.enchant.screens

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wasteland.enchant.Home
import com.wasteland.enchant.Login
import com.wasteland.enchant.R
import com.wasteland.enchant.ui.theme.appBlue
import com.wasteland.enchant.utils.Result
import com.wasteland.enchant.utils.Validations
import kotlinx.coroutines.delay

@Composable
fun SignUpContainer(nav: NavHostController, modifier: Modifier = Modifier) {
    var username by remember {
        mutableStateOf(TextFieldValue())
    }
    var email by remember {
        mutableStateOf(TextFieldValue())
    }
    var password by remember {
        mutableStateOf(TextFieldValue())
    }
    var confirmPassword by remember {
        mutableStateOf(TextFieldValue())
    }
    var showPassword by remember {
        mutableStateOf(false)
    }

    var resultUI by remember {
        mutableStateOf(Result(true, ""))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(0))
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Welcome to Chatty",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Signup your Account",
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(text = "Username")
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_user),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .onFocusChanged {
                        if (!it.isFocused) {
                            resultUI = Validations.validate("sas")
                        }
                    },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_mail),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                isError = resultUI.isValid,
                supportingText = {Text(text = resultUI.message)},
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
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
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text(text = "Confirm Password") },
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_shield),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(0.75f),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Already have an\naccount?",
                    fontSize = 14.sp,
                    modifier = Modifier.clickable {
                        nav.popBackStack()
                        nav.navigate(Login)
                    }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AnimatedButton(enabled = true, text = "", onClick = {nav.navigate(Home)}) {
                    Text(text = "Signup")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icon_login),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}


@Composable
fun SignUpScreen(nav: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        SignUpContainer(nav = nav, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun AnimatedButton(
    enabled:Boolean,
    text:String,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var isLoading by remember { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }
    var animating by remember { mutableStateOf(false) }


    val horizontalPadding by animateDpAsState(
        targetValue = if (animating) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 200, easing = EaseOut),
        finishedListener = {
            if (animating) {
                showProgress = true
                animating = false
            }
        }, label = ""
    )

    val visibility by animateFloatAsState(
        targetValue = if(showProgress) 1f else 0f,
        animationSpec = tween(durationMillis = 1090, easing = EaseIn),
        label = ""
    )

    LaunchedEffect(isLoading) {
        if(isLoading){
            animating = true
            delay(3000)
            isLoading = false
            showProgress = false
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)

    ) {
        if (showProgress) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp)
                    .graphicsLayer {
                        this.alpha = visibility
                    },
                color = colorResource(id = R.color.teal_200)
            )


        } else {
            Button(
                onClick = {
                    isLoading = true
                },
                enabled = enabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        this.alpha = 1 - visibility
                    },
                colors = ButtonDefaults.buttonColors()
                    .copy(
                        containerColor = appBlue,
                        contentColor = Color.White,
                    )
            ) {
                if(animating) Text("") else {content()}
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
