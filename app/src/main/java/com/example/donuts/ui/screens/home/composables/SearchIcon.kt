package com.example.donuts.ui.screens.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.donuts.R

@Composable
fun SearchIcon(
    onSearchIconClicked: () -> Unit,
) {
    Card(
        modifier = Modifier
            .clickable { onSearchIconClicked() },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Icon(
            modifier = Modifier.padding(8.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search Icon",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}