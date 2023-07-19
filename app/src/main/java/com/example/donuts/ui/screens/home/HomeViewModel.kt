package com.example.donuts.ui.screens.home

import com.example.donuts.ui.screens.base.BaseViewModel
import com.example.donuts.utils.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeUiState>(HomeUiState()) {


    init {
        updateState { it.copy(topOffers = DataSource.todayOffers, donuts = DataSource.donuts) }
    }

    fun onClickCardFavoriteIcon(position: Int) {
        updateState {
            it.copy(
                topOffers = it.topOffers.mapIndexed { index, donutUiState ->
                    if (index == position) {
                        donutUiState.copy(favoriteIcon = !donutUiState.favoriteIcon)
                    } else {
                        donutUiState
                    }
                }
            )
        }
    }
}