package com.example.flow.domain.usecases

import com.example.flow.domain.repository.UsersRepository
import com.example.flow.models.UserEntity
import com.example.flow.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    suspend fun getUsers(): Flow<DataState<List<UserEntity>, String>> =
        repository.getUsers()
}