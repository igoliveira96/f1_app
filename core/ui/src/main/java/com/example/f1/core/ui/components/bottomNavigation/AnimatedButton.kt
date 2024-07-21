@file:Suppress("FunctionNaming")

package com.example.f1.core.ui.components.bottomNavigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.f1.core.ui.data.BottomNavigationItemUI
import com.example.f1.core.ui.theme.Red
import com.example.f1.core.ui.utils.times
import com.example.f1.core.ui.utils.transform

@Composable
fun AppNavigationButton(
    navigationItemUI: BottomNavigationItemUI,
    paddingValues: PaddingValues,
    animationProgress: Float,
    onClick: (BottomNavigationItemUI) -> Unit = { }
) {
    AnimatedFab(
        icon = navigationItemUI.unselectedIcon,
        modifier = Modifier
            .padding(
                paddingValues * FastOutSlowInEasing.transform(
                    navigationItemUI.animationFrom,
                    navigationItemUI.animationTo,
                    animationProgress
                )
            ),
        opacity = LinearEasing.transform(
            navigationItemUI.opacityFrom,
            navigationItemUI.opacityTo,
            animationProgress
        ),
        onClick = { onClick(navigationItemUI) }
    )
}

@Composable
fun AnimatedFab(
    modifier: Modifier,
    icon: ImageVector? = null,
    opacity: Float = 1f,
    backgroundColor: Color = Red,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onClick,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
        containerColor = backgroundColor,
        shape = CircleShape,
        modifier = modifier.scale(1f)
    ) {
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.White.copy(alpha = opacity)
            )
        }
    }
}

