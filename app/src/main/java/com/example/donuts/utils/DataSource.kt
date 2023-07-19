package com.example.donuts.utils

import com.example.donuts.R
import com.example.donuts.ui.screens.home.Donuts
import com.example.donuts.ui.screens.home.TodayOffers

object DataSource {


    val todayOffers = listOf(
        TodayOffers(image = R.drawable.donut1, title = "Strawberry Wheel", description = "These Baked Strawberry Donuts are filled with fresh strawberries....", price = 16, discount = 22),
        TodayOffers(image = R.drawable.donut3, title = "Chocolate Glaze", description = " Moist and fluffy baked chocolate donuts full of chocolate flavor.", price = 16, discount = 19),
    )

    val donuts = listOf(
        Donuts(image = R.drawable.donuts1, title = "Chocolate Cherry", price = 22),
        Donuts(image = R.drawable.donuts2, title = "Strawberry Rain", price = 19),
        Donuts(image = R.drawable.donuts3, title = "Strawberry ", price = 16),
    )

}