package com.danik.tutuapp.presentation.screens.xml.list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.danik.tutuapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(useCases: UseCases) : ViewModel() {
    val allTrains = useCases.getAllTrainsUseCase().cachedIn(viewModelScope)
}