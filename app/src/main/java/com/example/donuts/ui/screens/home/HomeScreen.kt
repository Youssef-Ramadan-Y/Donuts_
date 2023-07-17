package com.example.donuts.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donuts.ui.screens.home.composables.HeaderText
import com.example.donuts.ui.screens.home.composables.SearchIcon
import com.example.donuts.ui.screens.home.composables.TodayOfferItem
import com.example.donuts.ui.theme.Type

@Composable
fun HomeScreen() {
    HomeContent(
        onSearchIconClicked = {},
        onTodayOfferClicked = {},
        onDonutsClicked = {},
    )
}

@Composable
fun HomeContent(
    onSearchIconClicked: () -> Unit,
    onTodayOfferClicked: () -> Unit,
    onDonutsClicked: () -> Unit,
) {
    LazyColumn() {
        item {
            HomeHeader(onSearchIconClicked = onSearchIconClicked)
        }
        item {
            TodayOffers(onTodayOfferClicked = onTodayOfferClicked)
        }

    }
}


@Composable
private fun HomeHeader(
    onSearchIconClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderText(
            title = "Let's Gonuts!",
            subTitle = "Order your favourite donuts from here",
        )
        SearchIcon(onSearchIconClicked = onSearchIconClicked)
    }
}


@Composable
fun TodayOffers(onTodayOfferClicked: () -> Unit) {
    Column() {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Today's Offer",
            style = Type.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(4) {
                TodayOfferItem(
                    title = "Strawberry Wheel",
                    description = "These Baked Strawberry Donuts are filled with fresh strawberries..",
                    onTodayOfferClicked = onTodayOfferClicked
                )
            }

        }
    }
}