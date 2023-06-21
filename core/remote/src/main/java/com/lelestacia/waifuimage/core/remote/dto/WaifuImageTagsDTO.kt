package com.lelestacia.waifuimage.core.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WaifuImageTagsDTO(

    @Json(name = "tag_id")
    val tagID: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "description")
    val description: String,

    @Json(name = "is_nsfw")
    val isNsfw: Boolean,
)
