package com.danik.tutuapp.presentation.screens.xml.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.danik.tutuapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
@HiltViewModel
class ListViewViewModel @Inject constructor(useCases: UseCases) : ViewModel() {

    val trains = useCases.getAllTrainsUseCase().cachedIn(viewModelScope)
}*/
