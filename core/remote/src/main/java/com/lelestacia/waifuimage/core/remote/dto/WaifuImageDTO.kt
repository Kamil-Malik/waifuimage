package com.lelestacia.waifuimage.core.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WaifuImageDTO(

    @Json(name = "signature")
    val signature: String,

    @Json(name = "extension")
    val extension: String,

    @Json(name = "image_id")
    val imageID: Int,

    @Json(name = "favorites")
    val favorites: Int,

    @Json(name = "dominant_color")
    val dominantColor: String,

    @Json(name = "source")
    val source: String?,

    @Json(name = "artist")
    val artist: WaifuImageArtistDTO?,

    @Json(name = "uploaded_at")
    val uploadedAt: String,

    @Json(name = "liked_at")
    val likedAt: String?,

    @Json(name = "is_nsfw")
    val isNsfw: Boolean,

    @Json(name = "width")
    val width: Int,

    @Json(name = "height")
    val height: Int,

    @Json(name = "byte_size")
    val byteSize: Int,

    @Json(name = "url")
    val url: String,

    @Json(name = "preview_url")
    val previewUrl: String,


    @Json(name = "tags")
    val tags: List<WaifuImageTagsDTO>
)
