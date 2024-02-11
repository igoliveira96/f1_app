package com.example.f1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.f1.core.navigation.AppNavigation
import com.example.f1.core.ui.components.bottomNavigation.AppBottomNavigation
import com.example.f1.core.ui.theme.F1Theme
import com.example.f1.core.ui.theme.values.LocalSpacing
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val spacing = LocalSpacing.current

            F1Theme {
                Scaffold {
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppBottomNavigation(
                            content = {
                                Column(
                                    modifier = Modifier.fillMaxWidth().padding(horizontal = spacing.medium)
                                ) {
                                    AppNavigation(navController = navController)
                                }
                            },
                            onClick = { bottomNavigationItem ->
                                navController.navigate(bottomNavigationItem.destination)
                            }
                        )
                    }
                }
            }
        }
    }
}
