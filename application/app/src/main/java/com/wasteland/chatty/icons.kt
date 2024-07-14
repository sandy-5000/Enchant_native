package com.wasteland.chatty

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getIcon(
    id: String,
    size: Dp = 20.dp,
): ImageVector {
    val map: Map<String, ImageVector> = mapOf(
        "login" to remember {
            ImageVector.Builder(
                name = "login",
                defaultWidth = size,
                defaultHeight = size,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(16.208f, 26.5f)
                    quadToRelative(-0.375f, -0.417f, -0.375f, -0.958f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                    lineToRelative(3.25f, -3.25f)
                    horizontalLineTo(6.583f)
                    quadToRelative(-0.541f, 0f, -0.916f, -0.375f)
                    reflectiveQuadToRelative(-0.375f, -0.958f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                    reflectiveQuadToRelative(0.916f, -0.375f)
                    horizontalLineToRelative(12.834f)
                    lineToRelative(-3.292f, -3.292f)
                    quadToRelative(-0.375f, -0.333f, -0.375f, -0.875f)
                    quadToRelative(0f, -0.541f, 0.417f, -0.958f)
                    quadToRelative(0.375f, -0.375f, 0.937f, -0.375f)
                    quadToRelative(0.563f, 0f, 0.938f, 0.375f)
                    lineToRelative(5.541f, 5.542f)
                    quadToRelative(0.209f, 0.208f, 0.292f, 0.437f)
                    quadToRelative(0.083f, 0.229f, 0.083f, 0.479f)
                    quadToRelative(0f, 0.292f, -0.083f, 0.5f)
                    quadToRelative(-0.083f, 0.209f, -0.292f, 0.417f)
                    lineToRelative(-5.541f, 5.542f)
                    quadToRelative(-0.334f, 0.375f, -0.875f, 0.354f)
                    quadToRelative(-0.542f, -0.021f, -0.959f, -0.396f)
                    close()
                    moveToRelative(5.334f, 8.375f)
                    quadToRelative(-0.542f, 0f, -0.938f, -0.396f)
                    quadToRelative(-0.396f, -0.396f, -0.396f, -0.937f)
                    quadToRelative(0f, -0.542f, 0.396f, -0.938f)
                    quadToRelative(0.396f, -0.396f, 0.938f, -0.396f)
                    horizontalLineToRelative(10.541f)
                    verticalLineTo(7.917f)
                    horizontalLineTo(21.542f)
                    quadToRelative(-0.542f, 0f, -0.938f, -0.396f)
                    quadToRelative(-0.396f, -0.396f, -0.396f, -0.938f)
                    quadToRelative(0f, -0.541f, 0.396f, -0.916f)
                    reflectiveQuadToRelative(0.938f, -0.375f)
                    horizontalLineToRelative(10.541f)
                    quadToRelative(1.084f, 0f, 1.855f, 0.771f)
                    quadToRelative(0.77f, 0.77f, 0.77f, 1.854f)
                    verticalLineToRelative(24.291f)
                    quadToRelative(0f, 1.084f, -0.77f, 1.875f)
                    quadToRelative(-0.771f, 0.792f, -1.855f, 0.792f)
                    close()
                }
            }.build()
        },
    )
    val icon = map[id] ?: throw Error("Invalid id")
    return icon
}
