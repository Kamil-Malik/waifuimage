package com.lelestacia.waifuimage.core.domain.usecases

import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.data.repository.IWaifuRepository
import com.lelestacia.waifuimage.core.model.WaifuImage
import kotlinx.coroutines.flow.Flow

class WaifuUseCases(
    private val repository: IWaifuRepository
): IWaifuUseCases {

    override fun getWaifuImages(): Flow<Resource<List<WaifuImage>>> {
        return repository.getWaifuImages()
    }
}