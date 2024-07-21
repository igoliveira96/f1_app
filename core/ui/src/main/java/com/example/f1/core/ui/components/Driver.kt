package com.example.f1.core.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.f1.core.ui.R
import com.example.f1.core.ui.data.DriverUI
import com.example.f1.core.ui.theme.F1Theme
import com.example.f1.core.ui.theme.Grey
import com.example.f1.core.ui.theme.values.LocalSpacing
import kotlinx.coroutines.launch

@Composable
fun Driver(driverUI: DriverUI) {
    val scope = rememberCoroutineScope()
    var points by remember { mutableStateOf("") }

    SideEffect {
        scope.launch {
            points = driverUI.points.toString()
        }
    }

    Card(
        modifier = Modifier.height(IntrinsicSize.Max),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DriverInfo(driverUI)
            DriverImage(driverUI, points)
        }
    }
}

@Composable
private fun DriverInfo(driverUI: DriverUI) {
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier.padding(start = spacing.medium)
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
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DriverImage(driverUI: DriverUI, points: String) {
    val spacing = LocalSpacing.current

    ConstraintLayout {
        val (driverImage, imageShadow, pointsLabel) = createRefs()

        AsyncImage(
            modifier = Modifier
                .padding(spacing.none)
                .constrainAs(driverImage) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .size(spacing.driverImage),
            model = ImageRequest.Builder(LocalContext.current)
                .data(driverUI.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
        Image(
            modifier = Modifier.constrainAs(imageShadow) {
                start.linkTo(driverImage.start)
                bottom.linkTo(parent.bottom)
            },
            painter = painterResource(id = R.drawable.driver_shadow),
            contentDescription = null
        )
        Row(
            modifier = Modifier
                .constrainAs(pointsLabel) {
                    start.linkTo(driverImage.start)
                    end.linkTo(driverImage.end)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
                .padding(bottom = spacing.extraSmall),
            horizontalArrangement = Arrangement.spacedBy(
                space = spacing.extraSmall,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            AnimatedContent(
                targetState = points,
                transitionSpec = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Up,
                        animationSpec = tween(durationMillis = 500)
                    ) togetherWith ExitTransition.None
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