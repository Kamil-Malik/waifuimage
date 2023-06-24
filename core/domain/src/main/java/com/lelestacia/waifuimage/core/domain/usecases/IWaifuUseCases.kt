package com.lelestacia.waifuimage.core.domain.usecases

import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.model.WaifuImage
import kotlinx.coroutines.flow.Flow

interface IWaifuUseCases {
    fun getWaifuImages(): Flow<Resource<List<WaifuImage>>>
}