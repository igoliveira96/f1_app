package com.example.f1.core.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.f1.core.ui.R
import com.example.f1.core.ui.data.DriverUI
import com.example.f1.core.ui.theme.F1Theme
import com.example.f1.core.ui.theme.Grey
import com.example.f1.core.ui.theme.values.LocalSpacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Driver(driverUI: DriverUI) {
    val scope = rememberCoroutineScope()
    val spacing = LocalSpacing.current
    var points by remember { mutableStateOf("") }

    SideEffect {
        scope.launch {
            points = driverUI.points.toString()
        }
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(spacing.medium)
            ) {
                Text(
                    driverUI.number.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(spacing.extraSmall))
                Text(
                    driverUI.firstName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    driverUI.lastName,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(spacing.extraSmall))
                Text(
                    driverUI.team,
                    style = MaterialTheme.typography.labelSmall,
                    color = Grey
                )
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    Modifier.fillMaxSize()
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(spacing.driverImage)
                            .padding(end = spacing.medium)
                            .align(Alignment.BottomEnd),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(driverUI.imageURL)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                    )
                    Image(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        painter = painterResource(id = R.drawable.driver_shadow),
                        contentDescription = null
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = spacing.mediumSmall),
                        horizontalArrangement = Arrangement.spacedBy(spacing.extraSmall)
                    ) {
                        AnimatedContent(
                            targetState = points,
                            transitionSpec = {
                                slideIntoContainer(
                                    towards = AnimatedContentScope.SlideDirection.Up,
                                    animationSpec = tween(durationMillis = 500)
                                ) with ExitTransition.None
                            },
                            label = ""
                        ) { targetPoints ->
                            Text(
                                text = targetPoints,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                        Text(
                            text = stringResource(R.string.driver_points),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DriverPreview() {
    F1Theme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Driver(DriverUI.EXAMPLE)
        }
    }
}