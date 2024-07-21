package com.example.f1.core.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PageTitle(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
) {
    Text(
        modifier = modifier,
        text = stringResource(title),
        color = Color.White,
        style = TextStyle.Default.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight.W500
        )
    )
}