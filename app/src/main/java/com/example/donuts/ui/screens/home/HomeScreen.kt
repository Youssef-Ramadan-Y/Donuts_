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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.donuts.ui.screens.donuts_details.navigateToDetailsScreen
import com.example.donuts.ui.screens.home.composables.DonutItem
import com.example.donuts.ui.screens.home.composables.HeaderText
import com.example.donuts.ui.screens.home.composables.SearchIcon
import com.example.donuts.ui.screens.home.composables.TodayOfferItem
import com.example.donuts.ui.theme.LightBlue
import com.example.donuts.ui.theme.Secondary
import com.example.donuts.ui.theme.Type
import com.example.donuts.ui.theme.pink

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state = state,
        navController,
        onSearchIconClicked = {},
        onDonutsClicked = {},
        onClickFavorite = {index -> viewModel.onClickCardFavoriteIcon(index)},
    )
}

@Composable
fun HomeContent(
    state: HomeUiState,
    navHostController: NavHostController,
    onSearchIconClicked: () -> Unit,
    onDonutsClicked: () -> Unit,
    onClickFavorite: (index: Int) -> Unit,
) {
    LazyColumn() {
        item {
            HomeHeader(onSearchIconClicked = onSearchIconClicked)
        }
        item {
            TodayOffer(state = state,navHostController, onClickFavorite = {index -> onClickFavorite(index)})
        }
        item {
            DonutsRow(
                state = state,
                onDonutsClicked = onDonutsClicked,
            )
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
            .padding(horizontal = 16.dp, vertical = 16.dp),
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
fun TodayOffer(
    state: HomeUiState,
    navHostController: NavHostController,
    onClickFavorite: (index: Int) -> Unit,

) {
    Column() {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Today's Offer",
            style = Type.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(state.topOffers) { index, item ->
                val color = if (index % 2 != 0) LightBlue else pink
                TodayOfferItem(
                    state = item,
                    tintColor = color,
                    onClickFavorite = { onClickFavorite(index) },
                    onTodayOfferClicked = { navHostController.navigateToDetailsScreen(index)}
                )
            }

        }
    }
}

@Composable
fun DonutsRow(
    state: HomeUiState,
    onDonutsClicked: () -> Unit,
) {

    Column() {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Donuts",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(state.donuts) { index, item ->
                DonutItem(
                    state = item,
                    onDonutClicked = onDonutsClicked
                )
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
    }

}