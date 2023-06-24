package com.lelestacia.waifuimage.core.domain.di

import com.lelestacia.waifuimage.core.data.repository.IWaifuRepository
import com.lelestacia.waifuimage.core.domain.usecases.IWaifuUseCases
import com.lelestacia.waifuimage.core.domain.usecases.WaifuUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    @ViewModelScoped
    fun provideWaifuUseCases(
        repository: IWaifuRepository
    ): IWaifuUseCases =
        WaifuUseCases(repository)
}