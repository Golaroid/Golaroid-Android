package com.idea_festival.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.idea_festival.golaroid_android.design_system.R

val pretendard = FontFamily(
    Font(R.font.pretendard_regular),
    Font(R.font.pretendard_semibold)
)

val Typography = Typography(
    // MainTitle
    headlineLarge = TextStyle( // MainTitle
        fontFamily = pretendard,
        fontSize = 30.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 36.sp
    ),

    // Head
    headlineMedium = TextStyle( // Head1
        fontFamily = pretendard,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle( // Head
        fontFamily = pretendard,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 29.sp
    ),

    // TitleSmall
    titleMedium = TextStyle( // TitleSmall_SemiBold
        fontFamily = pretendard,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 21.sp
    ),
    titleSmall = TextStyle( // TitleSmall_Regular
        fontFamily = pretendard,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 21.sp
    ),

    // BodyLarge
    bodyLarge = TextStyle( // BodyLarge_Regular
        fontFamily = pretendard,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 19.sp
    ),
    bodyMedium = TextStyle( // BodyLarge_Medium
        fontFamily = pretendard,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 19.sp
    ),
    bodySmall = TextStyle( // BodyLarge_SemiBold
        fontFamily = pretendard,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 19.sp
    ),

    // BodyMedium
    labelLarge = TextStyle( // BodyMedium_Regular
        fontFamily = pretendard,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 17.sp
    ),
    labelMedium = TextStyle( // BodyLarge_Medium
        fontFamily = pretendard,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 17.sp
    ),

    // BodySmall
    labelSmall = TextStyle( // BodyLarge_Medium
        fontFamily = pretendard,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 14.sp
    ),
)