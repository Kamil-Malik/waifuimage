package com.lelestacia.waifuimage.core.remote.endpoint

import com.lelestacia.waifuimage.core.remote.dto.ImagesDTO
import com.lelestacia.waifuimage.core.remote.dto.WaifuImageDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WaifuImageEndpoint {

    @GET("search/")
    suspend fun getWaifuImages(
        @Query("gif") gif: Boolean = false,
        @Query("orientation") orientation: String = "PORTRAIT",
        @Query("many") many: Boolean = true
    ): ImagesDTO<List<WaifuImageDTO>>

    companion object {
        const val BASE_URL = "https://api.waifu.im/"
    }
}