package com.example.f1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.f1.core.ui.components.Driver
import com.example.f1.core.ui.theme.F1Theme
import com.example.f1.core.ui.data.DriverUI
import com.example.f1.core.ui.theme.values.LocalSpacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val spacing = LocalSpacing.current

            F1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(spacing.medium)
                    ) {
                        Driver(driverUI = DriverUI.EXAMPLE)
                    }
                }
            }
        }
    }
}
