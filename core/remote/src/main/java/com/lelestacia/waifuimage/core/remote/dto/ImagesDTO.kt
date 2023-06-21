package com.lelestacia.waifuimage.core.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesDTO<T>(

    @Json(name = "images")
    val images: T
)
