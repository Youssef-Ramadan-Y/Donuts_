package com.example.donuts.ui.screens.home


data class HomeUiState(
    val topOffers: List<TodayOffers> = emptyList(),
    val donuts: List<Donuts> = emptyList()
)

data class TodayOffers(
    var favoriteIcon: Boolean = false,
    val image : Int = 0,
    val title : String = "",
    val description: String = "",
    val price: Int = 0,
    val discount: Int = 0,
)

data class Donuts(
    val image : Int = 0,
    val title : String = "",
    val price: Int = 0,
)