package com.example.donuts.ui.screens.home.composables

import androidx.constraintlayout.compose.ConstraintLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donuts.R
import com.example.donuts.ui.theme.Type
import com.example.donuts.ui.theme.LightBlue


@Composable
fun TodayOfferItem(
    title: String,
    description: String,
    onTodayOfferClicked: () -> Unit
) {

    Box(
        modifier = Modifier
            .height(325.dp)
            .width(193.dp)
            .clickable { onTodayOfferClicked() },
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (donut, card) = createRefs()

            // card
            Box(
                modifier = Modifier
                    .constrainAs(card) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .fillMaxHeight()
                    .width(150.dp)
                    .background(LightBlue, shape = RoundedCornerShape(16.dp)),
            ) {

                CircleIcon()
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                ) {

                    ItemText(title = title, description = description)
                    ItemPrice(
                        modifier = Modifier.padding(top = 4.dp),
                        afterDiscount = 16,
                        beforeDiscount = 20,
                    )
                }
            }

            // donut
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .constrainAs(donut) {
                        top.linkTo(parent.top, 50.dp)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop ,
                painter = painterResource(id = R.drawable.donut2),
                contentDescription = null
            )

        }


    }

}

@Composable
private fun ItemText(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = Type.titleSmall,
            color = MaterialTheme.colorScheme.onPrimary,

            )
        Text(
            text = description,
            style = Type.bodySmall,
            color = MaterialTheme.colorScheme.onSecondary,
        )
    }
}

@Composable
private fun ItemPrice(modifier: Modifier = Modifier, afterDiscount: Int, beforeDiscount: Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = modifier.align(Alignment.BottomEnd)) {
            Text(
                text = "$$beforeDiscount",
                textDecoration = TextDecoration.LineThrough,
                style = Type.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "$$afterDiscount",
                style = Type.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Preview
@Composable
fun any() {
    TodayOfferItem(
        title = "Strawberry Wheel",
        description = "These Baked Strawberry Donuts are filled with fresh strawberries.." ,
        {}
    )
}