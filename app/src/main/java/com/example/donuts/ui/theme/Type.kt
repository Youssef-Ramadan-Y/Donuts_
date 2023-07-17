package com.example.donuts.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.donuts.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Inner = FontFamily(
    Font(R.font.inter, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)


val Type = Typography(
    headlineLarge = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.Bold,
        fontSize = 54.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        letterSpacing = 0.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.sp
    ),

    labelLarge = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(

    ),
    labelSmall = TextStyle(),

    displayLarge = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Inner,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
)