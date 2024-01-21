package com.example.f1.feature.circuits

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.f1.core.ui.components.Circuit
import com.example.f1.core.ui.components.PageTitle
import com.example.f1.core.ui.data.CircuitUI

@Composable
fun CircuitsScreen(viewModel: CircuitsViewModel) {
    Column {
        PageTitle(title = R.string.circuits)
//        Spacer(modifier = Modifier.padding(top = 24.dp))
        Circuit(circuitUI = CircuitUI.EXAMPLE)
    }

}