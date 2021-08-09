package com.example.flow.domain.repository

import androidx.lifecycle.LiveData
import com.example.flow.models.UserEntity
import com.example.flow.utils.DataState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsers(): Flow<DataState<List<UserEntity>, String>>

}