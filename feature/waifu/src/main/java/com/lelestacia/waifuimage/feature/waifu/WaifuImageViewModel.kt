package com.lelestacia.waifuimage.feature.waifu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.domain.usecases.IWaifuUseCases
import com.lelestacia.waifuimage.core.model.WaifuImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WaifuImageViewModel @Inject constructor(
    private val useCases: IWaifuUseCases
) : ViewModel() {

    private val _waifu: MutableStateFlow<Resource<List<WaifuImage>>> =
        MutableStateFlow(Resource.None)
    val waifu: StateFlow<Resource<List<WaifuImage>>> = _waifu.asStateFlow()

    fun getWaifus() = viewModelScope.launch {
        useCases.getWaifuImages().collectLatest { waifuResult ->
            _waifu.update { waifuResult }
        }
    }
}