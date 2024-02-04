package com.example.f1.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.f1.core.ui.R
import com.example.f1.core.ui.theme.Grey
import com.example.f1.core.ui.theme.values.LocalSpacing

@Composable
fun TextWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes icon: Int,
    color: Color = Grey,
    iconTint: Color = color
) {
    val typography = MaterialTheme.typography
    val spacing = LocalSpacing.current

    Row(
        modifier =  modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(icon),
            modifier = Modifier.size(spacing.medium),
            contentDescription = ""
        )
        Text(
            text = text,
            style = typography.labelSmall,
        )
    }
}

@Preview
@Composable
private fun TextWithIconPreview() {
    TextWithIcon(
        text = stringResource(R.string.example_text),
        icon = R.drawable.ic_location
    )
}