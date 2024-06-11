package com.nc.dragonbites.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nc.dragonbites.ui.detail.DetailScreen
import com.nc.dragonbites.ui.theme.DragonBitesTheme
import com.nc.dragonbites.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DragonBitesTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController,
                        startDestination = Screen.Home.route) {

                        composable(Screen.Home.route) {
                            HomeScreen(navController)
                        }

                        composable(Screen.Detail.route + "/{id}",
                            arguments = listOf(
                                navArgument("id") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            DetailScreen(backStackEntry)
                        }
                    }
                }
            }
        }
    }
}
