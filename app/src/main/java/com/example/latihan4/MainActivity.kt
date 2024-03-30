package com.example.latihan4

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavDeepLink
import androidx.navigation.compose.*
import com.example.latihan4.ui.theme.Latihan4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup deep link intent filter
        setupDeepLinkIntentFilter()

        setContent {
            Latihan4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = rememberNavController()) {
                        composable("fragmentA") {
                            Greeting("Android")
                        }
                    }
                }
            }
        }
    }

    private fun setupDeepLinkIntentFilter() {
        val uri = Uri.parse("https://example.com/fragmentA")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addCategory(Intent.CATEGORY_BROWSABLE)

        // Add deep link intent filter
        this@MainActivity.intent = intent
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
    Latihan4Theme {
        Greeting("Android")
    }
}
