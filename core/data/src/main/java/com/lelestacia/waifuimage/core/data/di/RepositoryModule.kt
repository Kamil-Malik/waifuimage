package com.lelestacia.waifuimage.core.data.di

import android.content.Context
import com.lelestacia.waifuimage.core.data.ErrorParserUtil
import com.lelestacia.waifuimage.core.data.repository.IWaifuRepository
import com.lelestacia.waifuimage.core.data.repository.WaifuRepository
import com.lelestacia.waifuimage.core.remote.source.IWaifuDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWaifuRepository(
        apiService: IWaifuDataSource,
        @ApplicationContext mContext: Context
    ): IWaifuRepository =
        WaifuRepository(
            apiService = apiService,
            errorParserUtil = ErrorParserUtil(context = mContext)
        )
}