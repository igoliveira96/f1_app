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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.f1.core.ui.R
import com.example.f1.core.ui.data.BottomNavigationItemUI
import com.example.f1.core.ui.data.BottomNavigationUI
import com.example.f1.core.ui.theme.Red
import com.example.f1.core.ui.utils.times
import com.example.f1.core.ui.utils.transform
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun AppBottomNavigation(
    content: @Composable () -> Unit,
    onClick: (BottomNavigationItemUI) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxSize()
        ) {
            content()
        }

        BottomNavigation(onClick = onClick)
    }
}

@Composable
private fun BottomNavigation(
    onClick: (BottomNavigationItemUI) -> Unit
) {
    val renderEffect = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        BottomNavigationUI.getRenderEffect().asComposeRenderEffect()
    } else {
        null
    }
    
    val isMenuExtended = remember { mutableStateOf(false) }

    val fabAnimationProgress by animateFloatAsState(
        targetValue = if (isMenuExtended.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ),
        label = "fab_animation_progress"
    )
    
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(vertical = 16.dp, horizontal = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        BottomNavigationContent { bottomNavigationItem ->
            if (isMenuExtended.value) {
                isMenuExtended.value = isMenuExtended.value.not()
            }
            onClick(bottomNavigationItem)
        }
        Circle(
            color = Red,
            animationProgress = 0.5f
        )
        FabGroup(
            renderEffect = renderEffect,
            animationProgress = fabAnimationProgress
        )
        FabGroup(
            renderEffect = null,
            animationProgress = fabAnimationProgress,
            toggleAnimation = {
                isMenuExtended.value = isMenuExtended.value.not()
            },
            onClick = { bottomNavigationItem ->
                isMenuExtended.value = isMenuExtended.value.not()
                onClick(bottomNavigationItem)
            }
        )
    }
}

@Composable
private fun BottomNavigationContent(
    onClick: (BottomNavigationItemUI) -> Unit = { }
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .paint(
                painter = painterResource(R.drawable.bottom_navigation),
                contentScale = ContentScale.FillHeight
            )
            .padding(horizontal = 48.dp)
    ) {
        BottomNavigationItemUI.DEFAULT.map { bottomNavigationItem ->
            IconButton(onClick = { onClick(bottomNavigationItem) }) {
                Icon(
                    imageVector = bottomNavigationItem.icon,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun Circle(color: Color, animationProgress: Float) {
    val animationValue = sin(PI * animationProgress).toFloat()

    Box(
        modifier = Modifier
            .padding(36.dp)
            .size(56.dp)
            .scale(2 - animationValue)
            .border(
                width = 2.dp,
                color = color.copy(alpha = color.alpha * animationValue),
                shape = CircleShape
            )
    )
}

@Composable
fun FabGroup(
    animationProgress: Float = 0f,
    renderEffect: androidx.compose.ui.graphics.RenderEffect? = null,
    toggleAnimation: () -> Unit = { },
    onClick: (BottomNavigationItemUI) -> Unit = { }
) {
    Box(
        Modifier
            .fillMaxSize()
            .graphicsLayer { this.renderEffect = renderEffect }
            .padding(bottom = 36.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        AppNavigationButton(
            navigationItemUI = BottomNavigationItemUI.CIRCUIT_ITEM,
            paddingValues = PaddingValues(bottom = 52.dp, end = 152.dp),
            animationProgress = animationProgress,
            onClick = onClick
        )
        AppNavigationButton(
            navigationItemUI = BottomNavigationItemUI.VIDEOS_ITEM,
            paddingValues = PaddingValues(bottom = 80.dp),
            animationProgress = animationProgress,
            onClick = onClick
        )
        AppNavigationButton(
            navigationItemUI = BottomNavigationItemUI.NEWS_ITEM,
            paddingValues = PaddingValues(bottom = 52.dp, start = 152.dp),
            animationProgress = animationProgress,
            onClick = onClick
        )

        AnimatedFab(
            modifier = Modifier
                .scale(1f - LinearEasing.transform(0.5f, 0.85f, animationProgress)),
        )

        AnimatedFab(
            icon = Icons.Default.Add,
            modifier = Modifier
                .rotate(
                    BottomNavigationUI.DEGREES * FastOutSlowInEasing
                        .transform(0.35f, 0.65f, animationProgress)
                ),
            onClick = toggleAnimation,
            backgroundColor = Color.Transparent
        )
    }
}

@Suppress("UnusedPrivateMember")
@Preview(device = "id:pixel_5", showBackground = true)
@Composable
private fun AppBottomNavigationPreview() {
    AppBottomNavigation(
        content = { },
        onClick = { }
    )
}