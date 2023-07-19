package com.example.donuts.ui.screens.donuts_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.donuts.R
import com.example.donuts.ui.screens.composables.BottomSheet
import com.example.donuts.ui.screens.donuts_details.composables.BottomSheetContent
import com.example.donuts.ui.screens.home.navigateToHomeScreen
import com.example.donuts.ui.theme.Primary

@Composable
fun DetailsScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val state by viewModel.state.collectAsState()

    DetailsContent(
        state = state,
        onBackClick = {navController.navigateToHomeScreen()},
        onDecreaseQuantity = { /*TODO*/ },
        onIncreaseQuantity = {/*TODO*/ },
    )
}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onDecreaseQuantity: () -> Unit,
    onIncreaseQuantity: () -> Unit,
) {

    Box(
        Modifier
            .background(state.backgroundColor)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onBackClick() }
                    .padding(4.dp),
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                contentDescription = "",
                tint = Primary,
            )
        }
        Image(
            modifier = Modifier
                .scale(6f)
                .padding(top = 60.dp)
                .align(Alignment.TopCenter),
            painter = painterResource(id = state.image),
            contentDescription = ""
        )


        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {

            BottomSheet(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                BottomSheetContent(
                    state, onDecreaseQuantity = { onDecreaseQuantity() },
                    onIncreaseQuantity = { onIncreaseQuantity() },
                )
            }
            FavIcon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 8.dp)
                    .offset(y = (-30).dp, x = (-20).dp),
                onFacIconClicked = {  }
            )
        }
    }
}


@Composable
fun FavIcon(
    modifier: Modifier = Modifier,
    onFacIconClicked: () -> Unit,
) {

    Box(
        modifier = modifier
            .size(45.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .clickable { onFacIconClicked() },
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.baseline_favorite_border_24),
            tint = Primary,
            contentDescription = "Search Icon",
        )
    }

}
@Preview
@Composable
fun PreviewDetails() {


}