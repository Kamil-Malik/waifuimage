package com.lelestacia.waifuimage.core.remote.source

import com.lelestacia.waifuimage.core.remote.dto.WaifuImageDTO

interface IWaifuDataSource {

    suspend fun getWaifuImages(): List<WaifuImageDTO>
}