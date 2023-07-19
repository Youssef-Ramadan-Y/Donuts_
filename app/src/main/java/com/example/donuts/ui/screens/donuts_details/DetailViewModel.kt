package com.example.donuts.ui.screens.donuts_details

import androidx.lifecycle.SavedStateHandle
import com.example.donuts.ui.screens.base.BaseViewModel
import com.example.donuts.ui.theme.LightBlue
import com.example.donuts.ui.theme.pink
import com.example.donuts.utils.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) :
    BaseViewModel<DetailsUiState>(DetailsUiState()) {

    private val args = DetailsArgs(savedStateHandle)

    init {
        val id = args.id.toString().toInt()
        getData(id)
    }

    private fun getData(id: Int) {
        DataSource.todayOffers.mapIndexed { index, todayOffers ->
            if (id == index) {
                updateState {
                    it.copy(
                        image = todayOffers.image,
                        title = todayOffers.title,
                        description = todayOffers.description,
                        price = todayOffers.discount,
                        backgroundColor = if (index % 2 != 0) LightBlue else pink,
                        favorite = todayOffers.favoriteIcon
                    )
                }
            }
        }
    }

}