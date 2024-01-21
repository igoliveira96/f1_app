package com.example.f1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.f1.core.navigation.AppNavigation
import com.example.f1.core.ui.data.BottomNavigationItemUI
import com.example.f1.core.ui.theme.F1Theme
import com.example.f1.core.ui.theme.LightSilver
import com.example.f1.core.ui.theme.values.LocalSpacing

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val spacing = LocalSpacing.current
            var selectedIndex by rememberSaveable { mutableStateOf(0) }

            F1Theme {
                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            containerColor = Color.Black,
                            contentColor = Color.Unspecified
                        ) {
                            BottomNavigationItemUI.DEFAULT.forEachIndexed { index, itemUI ->
                                NavigationBarItem(
                                    selected = selectedIndex == index,
                                    onClick = {
                                        selectedIndex = index
                                        navController.navigate(itemUI.destination)
                                    },
                                    label = {
                                        Text(
                                            text = itemUI.title,
                                            color = if (selectedIndex == index) {
                                                Color.White
                                            } else LightSilver
                                        )
                                    },
                                    alwaysShowLabel = true,
                                    colors = NavigationBarItemDefaults
                                        .colors(
                                            selectedIconColor = Color.Unspecified,
                                            indicatorColor = Color.Unspecified
                                        ),
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if (itemUI.badgeCount != null) {
                                                    Badge {
                                                        Text(itemUI.badgeCount.toString())
                                                    }
                                                } else if (itemUI.hasNews) {
                                                    Badge()
                                                }
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (selectedIndex == index) {
                                                    itemUI.selectedIcon
                                                } else itemUI.unselectedIcon,
                                                contentDescription = itemUI.title,
                                                tint = if (selectedIndex == index) {
                                                    Color.White
                                                } else LightSilver
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(spacing.medium)
                        ) {
                            AppNavigation(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
