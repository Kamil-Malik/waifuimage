package com.lelestacia.waifuimage.core.data.mapper

import com.lelestacia.waifuimage.core.model.WaifuImage
import com.lelestacia.waifuimage.core.model.WaifuImageArtist
import com.lelestacia.waifuimage.core.model.WaifuImageTags
import com.lelestacia.waifuimage.core.remote.dto.WaifuImageArtistDTO
import com.lelestacia.waifuimage.core.remote.dto.WaifuImageDTO

fun WaifuImageDTO.asWaifuImage() =
    WaifuImage(
        signature = signature,
        extension = extension,
        imageID = imageID,
        favorites = favorites,
        dominantColor = dominantColor,
        source = source,
        artist =
        if (artist == null) null
        else WaifuImageArtist(
            artistID = (artist as WaifuImageArtistDTO).artistID,
            name = (artist as WaifuImageArtistDTO).name,
            patreon = artist?.patreon,
            twitter = artist?.twitter,
            deviantArt = artist?.deviantArt
        ),
        uploadedAt = uploadedAt,
        likedAt = likedAt,
        isNsfw = isNsfw,
        width = width,
        height = height,
        byteSize = byteSize,
        url = url,
        previewUrl = previewUrl,
        tags = tags.map { dto ->
            WaifuImageTags(
                tagID = dto.tagID,
                name = dto.name,
                description = dto.description,
                isNsfw = dto.isNsfw
            )
        }
    )