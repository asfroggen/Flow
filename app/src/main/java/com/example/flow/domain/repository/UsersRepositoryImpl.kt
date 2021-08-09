package com.example.flow.domain.repository

import com.example.flow.data.local.UsersDao
import com.example.flow.domain.remote.RemoteDataSource
import com.example.flow.models.UserEntity
import com.example.flow.utils.DataState
import kotlinx.coroutines.flow.*

class UsersRepositoryImpl constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: UsersDao
) : UsersRepository {


    override suspend fun getUsers(): Flow<DataState<List<UserEntity>, String>> =
        remoteDataSource.getUsers()

}