package com.lelestacia.waifuimage.feature.waifu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.model.WaifuImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WaifuImageScreen(
    waifuResource: Resource<List<WaifuImage>>,
    onWaifuClicked: (WaifuImage) -> Unit,
    onRetry: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onRetry) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
            }
        }
    ) { scaffoldPaddingValue ->
        when (waifuResource) {
            is Resource.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(scaffoldPaddingValue)
                ) {
                    Text(text = waifuResource.message ?: "")
                    Button(onClick = onRetry) {
                        Text(text = "Retry")
                    }
                }
            }

            Resource.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(scaffoldPaddingValue)
                ) {
                    CircularProgressIndicator()
                }
            }

            Resource.None -> Unit
            is Resource.Success -> {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(scaffoldPaddingValue)
                        .padding(horizontal = 8.dp)
                ) {
                    items(
                        items = waifuResource.data ?: emptyList(),
                        key = { it.imageID }) { waifuImage ->
                        WaifuImageView(
                            waifu = waifuImage,
                            onWaifuClicked = onWaifuClicked
                        )
                    }
                }
            }
        }
    }
}