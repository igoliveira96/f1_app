@file:Suppress("FunctionNaming")

package com.example.f1.core.ui.components.bottomNavigation

import android.os.Build
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.f1.core.ui.R
import com.example.f1.core.ui.data.BottomNavigationItemUI
import com.example.f1.core.ui.data.BottomNavigationUI
import com.example.f1.core.ui.theme.Background
import com.example.f1.core.ui.theme.Red
import com.example.f1.core.ui.utils.times
import com.example.f1.core.ui.utils.transform
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun AppBottomNavigation(navController: NavController) {
    BottomNavigationContent { destination ->
        navController.navigate(destination)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomNavigationContent(
    navigate: (destination: String) -> Unit = { }
) {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    NavigationBar(
        containerColor = Background
    ) {
        BottomNavigationItemUI.DEFAULT.forEachIndexed { index, itemUI ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    navigate(itemUI.destination)
                },
                label = {
                    Text(
                        text = itemUI.title,
                        color = Color.White
                    )
                },
                alwaysShowLabel = false,
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
                            contentDescription = itemUI.title
                        )
                    }
                }
            )
        }
    }
}

@Suppress("UnusedPrivateMember")
@Preview(device = "id:pixel_5", showBackground = true)
@Composable
private fun AppBottomNavigationPreview() {
    BottomNavigationContent {}
}