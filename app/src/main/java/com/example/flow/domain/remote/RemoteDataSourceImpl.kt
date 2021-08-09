package com.example.flow.domain.remote

import com.example.flow.data.local.CacheMapper
import com.example.flow.data.local.UsersDao
import com.example.flow.data.network.ReqresApi
import com.example.flow.models.UserEntity
import com.example.flow.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val api: ReqresApi,
    private val dao: UsersDao,
    private val cacheMapper: CacheMapper
) : RemoteDataSource {

    override suspend fun getUsers(): Flow<DataState<List<UserEntity>, String>> {
        return flow {
            emit(DataState.Loading)

            val response = api.getUsers()

            if (response.isSuccessful) {
                val networkUsers = response.body()?.data

                if (networkUsers != null) {
                    for (user in networkUsers) {
                        dao.insertUser(cacheMapper.mapToEntity(user))
                    }
                    val cacheUsers = dao.getUsers()
                    emit(DataState.Success(cacheUsers))
                    emit(DataState.Finished)
                }else {
                    emit(DataState.Error("Something goes wrong retrieving the data"))
                }
            } else {
                emit(DataState.Error("Something goes wrong with the call"))
            }
        }
    }
}