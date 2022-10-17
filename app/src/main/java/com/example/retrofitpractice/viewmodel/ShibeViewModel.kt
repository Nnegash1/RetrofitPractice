package com.example.retrofitpractice.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitpractice.model.ShibeRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShibeViewModel : ViewModel() {
    private val _shibeState: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    val shibeState get() = _shibeState.asStateFlow()

    fun getShibe(count: String) = viewModelScope.launch {
        val result = ShibeRepo.getShibe(count)
        _shibeState.value = result
    }
}