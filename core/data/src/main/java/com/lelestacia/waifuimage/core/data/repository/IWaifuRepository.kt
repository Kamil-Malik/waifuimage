package com.lelestacia.waifuimage.core.data.repository

import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.model.WaifuImage
import kotlinx.coroutines.flow.Flow

interface IWaifuRepository {
    fun getWaifuImages(): Flow<Resource<List<WaifuImage>>>
}