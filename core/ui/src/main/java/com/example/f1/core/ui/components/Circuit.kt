package com.example.f1.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.f1.core.ui.R
import com.example.f1.core.ui.data.CircuitUI
import com.example.f1.core.ui.theme.F1Theme
import com.example.f1.core.ui.theme.values.LocalSpacing

@Composable
fun Circuit(circuitUI: CircuitUI) {
    val spacing = LocalSpacing.current

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .padding(spacing.medium),
       ) {
           CircuitInfo(circuitUI)
       }
    }
}

@Composable
private fun CircuitInfo(circuitUI: CircuitUI) {
    val spacing = LocalSpacing.current

    Column(
        verticalArrangement = Arrangement.spacedBy(spacing.extraSmall)
    ) {
        Text(
            circuitUI.competition.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        TextWithIcon(
            text = stringResource(
                R.string.circuit_name_and_location,
                circuitUI.name,
                circuitUI.competition.location.country ?: "-"
            ),
            icon = R.drawable.ic_location
        )
        if (!circuitUI.lapRecordUI.isEmpty) {
            TextWithIcon(
                text = stringResource(
                    R.string.circuit_record,
                    circuitUI.lapRecordUI.time ?: "",
                    circuitUI.lapRecordUI.driver ?: "",
                    circuitUI.lapRecordUI.year ?: "",
                ),
                icon = R.drawable.ic_timer
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextWithIcon(
                text = stringResource(R.string.number_of_laps, circuitUI.laps),
                icon = R.drawable.ic_laps
            )
            TextWithIcon(
                text = stringResource(R.string.circuit_length, circuitUI.length),
                icon = R.drawable.ic_distance
            )
        }
    }
}

@Preview
@Composable
private fun CircuitPreview() {
    F1Theme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Circuit(CircuitUI.EXAMPLE)
        }
    }
}