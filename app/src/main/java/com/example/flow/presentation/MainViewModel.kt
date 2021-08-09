package com.example.flow.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.domain.usecases.GetUsersUseCase
import com.example.flow.models.UserEntity
import com.example.flow.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel
@ViewModelInject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _userDataState: MutableLiveData<DataState<List<UserEntity>, String>> = MutableLiveData()
    val userDataState: LiveData<DataState<List<UserEntity>, String>>
        get() = _userDataState

    fun getUsers(){
        viewModelScope.launch {
            getUsersUseCase.getUsers()
                .onEach { dataState ->
                    _userDataState.value = dataState
                }.launchIn(viewModelScope)
        }
    }
}