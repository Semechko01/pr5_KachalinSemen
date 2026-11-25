package com.example.pr5_kachalin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pr5_kachalin.ui.navigation.AppHavHost
import com.example.pr5_kachalin.ui.screens.ListScreen
import com.example.pr5_kachalin.ui.theme.Pr5_KachalinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pr5_KachalinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppHavHost(navController = navController)
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Pr5_KachalinTheme {
        ListScreen(navController = rememberNavController())
    }
}