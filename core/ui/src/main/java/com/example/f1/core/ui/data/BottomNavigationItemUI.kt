package com.example.f1.core.ui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.SportsScore
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemUI(
    val title: String,
    val icon: ImageVector,
    val destination: String,
    val animationFrom: Float = 0f,
    val animationTo: Float = 0f,
    val opacityFrom: Float = 0f,
    val opacityTo: Float = 0f
) {

    companion object {
        val DEFAULT = listOf(
            BottomNavigationItemUI(
                title = "Racing",
                icon = Icons.Filled.SportsScore,
                destination = "home/racing"
            ),
            BottomNavigationItemUI(
                title = "Standings",
                icon = Icons.Filled.EmojiEvents,
                destination = "home/standings"
            ),
        )

        val CIRCUIT_ITEM = BottomNavigationItemUI(
            title = "Circuits",
            icon = Icons.Filled.Flag,
            destination = "home/circuits",
            animationFrom = 0f,
            animationTo = 0.8f,
            opacityFrom = 0.3f,
            opacityTo = 0.8f
        )

        val NEWS_ITEM = BottomNavigationItemUI(
            title = "News",
            icon = Icons.Filled.Newspaper,
            destination = "home/news",
            animationFrom = 0.1f,
            animationTo = 0.9f,
            opacityFrom = 0.3f,
            opacityTo = 0.8f
        )

        val VIDEOS_ITEM = BottomNavigationItemUI(
            title = "Videos",
            icon = Icons.Filled.VideoLibrary,
            destination = "home/videos",
            animationFrom = 0.2f,
            animationTo = 1.0f,
            opacityFrom = 0.4f,
            opacityTo = 0.9f
        )
    }

}