package com.wasteland.enchant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wasteland.enchant.screens.HomeScreen
import com.wasteland.enchant.screens.LoginScreen
import com.wasteland.enchant.screens.SignUpScreen
import com.wasteland.enchant.ui.theme.EnchantTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnchantTheme {
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
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnchantTheme {
        Greeting("Android")
    }
}


@Serializable
object Login

@Serializable
object SignUp

@Serializable
object Home
