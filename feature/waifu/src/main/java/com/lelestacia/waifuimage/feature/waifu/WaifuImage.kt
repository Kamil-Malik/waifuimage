package com.lelestacia.waifuimage.feature.waifu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lelestacia.waifuimage.core.model.WaifuImage
import com.lelestacia.waifuimage.core.model.WaifuImageArtist
import com.lelestacia.waifuimage.core.model.WaifuImageTags
import com.lelestacia.waifuimage.core.theme.WaifuImageTheme

@Composable
fun WaifuImageView(
    waifu: WaifuImage,
    onWaifuClicked: (WaifuImage) -> Unit
) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.clickable { onWaifuClicked(waifu) }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(waifu.url)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .aspectRatio(waifu.width/waifu.height.toFloat())
        )
    }
}

@Preview
@Composable
fun PreviewWaifuImage() {
    val waifu = WaifuImage(
        signature = "0812f17322aabb1e",
        extension = ".png",
        imageID = 7540,
        favorites = 1,
        dominantColor = "#e0cbc0",
        source = "https://www.pixiv.net/en/artworks/96488542",
        artist = WaifuImageArtist(
            artistID = 437,
            name = "HY_LOGIC",
            patreon = null,
            twitter = "https://www.pixiv.net/users/77949209",
            deviantArt = "https://twitter.com/HY_LOGIC",
        ),
        uploadedAt = "2022-02-26T05:12:50.031442+01:00",
        likedAt = null,
        isNsfw = false,
        width = 5326,
        height = 7737,
        byteSize = 14920863,
        url = "https://cdn.waifu.im/7540.png",
        previewUrl = "https://www.waifu.im/preview/7540/",
        tags = listOf(
            WaifuImageTags(
                tagID = 11,
                name = "uniform",
                description = "Girls wearing any kind of uniform, cosplay etc... ",
                isNsfw = false
            ),
            WaifuImageTags(
                tagID = 5,
                name = "marin-kitagawa",
                description = "One of two main protagonists (alongside Wakana Gojo) in the anime and manga series My Dress-Up Darling.",
                isNsfw = false
            ),
            WaifuImageTags(
                tagID = 12,
                name = "waifu",
                description = "A female anime/manga character.",
                isNsfw = false
            )
        )
    )
    WaifuImageTheme {
        WaifuImageView(
            waifu = waifu,
            onWaifuClicked = {}
        )
    }
}