package com.example.flow.domain.remote

import com.example.flow.models.UserEntity
import com.example.flow.utils.DataState
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getUsers(): Flow<DataState<List<UserEntity>, String>>
}