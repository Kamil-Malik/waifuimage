package com.lelestacia.waifuimage.core.remote.di

import com.lelestacia.waifuimage.core.remote.endpoint.WaifuImageEndpoint
import com.lelestacia.waifuimage.core.remote.source.IWaifuDataSource
import com.lelestacia.waifuimage.core.remote.source.WaifuDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitAndDataSourceModule {

    @Provides
    @Singleton
    fun provideWaifuImagesEndpoint(
        okHttpClient: OkHttpClient
    ): WaifuImageEndpoint =
        Retrofit.Builder()
            .baseUrl(WaifuImageEndpoint.BASE_URL)
            .client(okHttpClient)
            .validateEagerly(true)
            .build()
            .create(WaifuImageEndpoint::class.java)

    @Provides
    @Singleton
    fun provideWaifuImagesDataSource(
        apiService: WaifuImageEndpoint
    ): IWaifuDataSource =
        WaifuDataSource(apiService)
}