package com.lelestacia.waifuimage.core.data.repository

import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.data.ErrorParserUtil
import com.lelestacia.waifuimage.core.data.mapper.asWaifuImage
import com.lelestacia.waifuimage.core.model.WaifuImage
import com.lelestacia.waifuimage.core.remote.dto.WaifuImageDTO
import com.lelestacia.waifuimage.core.remote.source.IWaifuDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class WaifuRepository @Inject constructor(
    private val apiService: IWaifuDataSource,
    private val errorParserUtil: ErrorParserUtil
) : IWaifuRepository {

    override fun getWaifuImages(): Flow<Resource<List<WaifuImage>>> {
        return flow<Resource<List<WaifuImage>>> {
            val apiResult = apiService.getWaifuImages()
            emit(Resource.Success(data = apiResult.map(WaifuImageDTO::asWaifuImage)))
        }.catch {
            emit(Resource.Error(data = null, message = errorParserUtil(it)))
        }.onStart {
            emit(Resource.Loading)
        }
    }
}