package com.lelestacia.waifuimage.core.remote.source

import com.lelestacia.waifuimage.core.remote.dto.WaifuImageDTO
import com.lelestacia.waifuimage.core.remote.endpoint.WaifuImageEndpoint
import javax.inject.Inject

class WaifuDataSource @Inject constructor(
    private val apiService: WaifuImageEndpoint
) : IWaifuDataSource {

    override suspend fun getWaifuImages(): List<WaifuImageDTO> {
        return apiService.getWaifuImages().images
    }
}