package com.example.donuts.ui.screens.donuts_details

import androidx.compose.ui.graphics.Color
import com.example.donuts.ui.theme.Secondary

data class DetailsUiState(
    val image: Int = 0,
    val backgroundColor : Color = Secondary,
    val favorite: Boolean = false,
    val title: String = "",
    val description: String = "",
    val price: Int = 0,
    val quantity: Int = 1
)