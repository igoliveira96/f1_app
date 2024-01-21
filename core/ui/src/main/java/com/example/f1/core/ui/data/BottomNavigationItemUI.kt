package com.example.f1.core.ui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.SportsScore
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.SportsScore
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemUI(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
) {

    companion object {
        val DEFAULT = listOf(
            BottomNavigationItemUI(
                title = "Racing",
                selectedIcon = Icons.Filled.SportsScore,
                unselectedIcon = Icons.Outlined.SportsScore,
                hasNews = false
            ),
            BottomNavigationItemUI(
                title = "Circuits",
                selectedIcon = Icons.Filled.Flag,
                unselectedIcon = Icons.Outlined.Flag,
                hasNews = false
            ),
            BottomNavigationItemUI(
                title = "Standings",
                selectedIcon = Icons.Filled.EmojiEvents,
                unselectedIcon = Icons.Outlined.EmojiEvents,
                hasNews = false
            ),
        )
    }

}