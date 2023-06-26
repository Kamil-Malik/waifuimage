package com.lelestacia.waifuimage.core.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WaifuImageArtistDTO(

    @Json(name = "artist_id")
    val artistID:Int,

    @Json(name = "name")
    val name:String,

    @Json(name = "patreon")
    val patreon:String?,

    @Json(name = "twitter")
    val twitter:String?,

    @Json(name = "deviant_art")
    val deviantArt:String?
)
