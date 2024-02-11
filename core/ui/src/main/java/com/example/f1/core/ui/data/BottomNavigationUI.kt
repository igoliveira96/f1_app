package com.example.f1.core.ui.data

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi

object BottomNavigationUI {

    const val DEGREES = 225

    @Suppress("MagicNumber")
    @RequiresApi(Build.VERSION_CODES.S)
    fun getRenderEffect(): RenderEffect {
        val blurEffect = RenderEffect
            .createBlurEffect(80f, 80f, Shader.TileMode.MIRROR)

        val alphaMatrix = RenderEffect.createColorFilterEffect(
            ColorMatrixColorFilter(
                ColorMatrix(
                    floatArrayOf(
                        1f, 0f, 0f, 0f, 0f,
                        0f, 1f, 0f, 0f, 0f,
                        0f, 0f, 1f, 0f, 0f,
                        0f, 0f, 0f, 50f, -5000f
                    )
                )
            )
        )

        return RenderEffect
            .createChainEffect(alphaMatrix, blurEffect)
    }

}