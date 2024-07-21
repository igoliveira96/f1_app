package com.example.f1.core.ui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.SportsScore
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.SportsScore
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemUI(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val destination: String,
    val animationFrom: Float = 0f,
    val animationTo: Float = 0f,
    val opacityFrom: Float = 0f,
    val opacityTo: Float = 0f,
    val badgeCount: Int? = null,
    val hasNews: Boolean = false
) {

    companion object {
        val DEFAULT = listOf(
            BottomNavigationItemUI(
                title = "Racing",
                selectedIcon = Icons.Filled.SportsScore,
                unselectedIcon = Icons.Outlined.SportsScore,
                destination = "home/racing"
            ),
            BottomNavigationItemUI(
                title = "Standings",
                selectedIcon = Icons.Filled.EmojiEvents,
                unselectedIcon = Icons.Outlined.EmojiEvents,
                destination = "home/standings"
            ),
            BottomNavigationItemUI(
                title = "Circuits",
                selectedIcon = Icons.Filled.Flag,
                unselectedIcon = Icons.Outlined.Flag,
                destination = "home/circuits",
                animationFrom = 0f,
                animationTo = 0.8f,
                opacityFrom = 0.3f,
                opacityTo = 0.8f
            )
        )

        val CIRCUIT_ITEM = BottomNavigationItemUI(
            title = "Circuits",
            selectedIcon = Icons.Filled.Flag,
            unselectedIcon = Icons.Outlined.Flag,
            destination = "home/circuits",
            animationFrom = 0f,
            animationTo = 0.8f,
            opacityFrom = 0.3f,
            opacityTo = 0.8f
        )

        val NEWS_ITEM = BottomNavigationItemUI(
            title = "News",
            selectedIcon = Icons.Filled.Newspaper,
            unselectedIcon = Icons.Outlined.Newspaper,
            destination = "home/news",
            animationFrom = 0.1f,
            animationTo = 0.9f,
            opacityFrom = 0.3f,
            opacityTo = 0.8f
        )

        val VIDEOS_ITEM = BottomNavigationItemUI(
            title = "Videos",
            selectedIcon = Icons.Filled.VideoLibrary,
            unselectedIcon = Icons.Outlined.VideoLibrary,
            destination = "home/videos",
            animationFrom = 0.2f,
            animationTo = 1.0f,
            opacityFrom = 0.4f,
            opacityTo = 0.9f
        )
    }

}