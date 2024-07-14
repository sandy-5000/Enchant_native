package com.wasteland.chatty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wasteland.chatty.screens.HomeScreen
import com.wasteland.chatty.screens.LoginScreen
import com.wasteland.chatty.screens.SignUpScreen
import com.wasteland.chatty.ui.theme.ChattyTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChattyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Login
                ) {
                    composable<Login> { LoginScreen(nav = navController) }
                    composable<SignUp> { SignUpScreen(nav = navController) }
                    composable<Home> { HomeScreen() }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize = 14.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChattyTheme {
        Greeting("Android")
    }
}

@Serializable
object Login

@Serializable
object SignUp

@Serializable
object Home
