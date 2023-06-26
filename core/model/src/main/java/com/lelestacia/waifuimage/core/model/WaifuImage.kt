package com.lelestacia.waifuimage.core.model

data class WaifuImage(

    val signature: String,

    val extension: String,

    val imageID: Int,

    val favorites: Int,

    val dominantColor: String,

    val source: String?,

    val artist: WaifuImageArtist?,

    val uploadedAt: String,

    val likedAt: String?,

    val isNsfw: Boolean,

    val width: Int,

    val height: Int,

    val byteSize: Int,

    val url: String,

    val previewUrl: String,

    val tags: List<WaifuImageTags>
)
