package com.example.flow.di

import com.example.flow.data.local.CacheMapper
import com.example.flow.data.local.UsersDao
import com.example.flow.data.network.ReqresApi
import com.example.flow.domain.remote.RemoteDataSource
import com.example.flow.domain.remote.RemoteDataSourceImpl
import com.example.flow.domain.repository.UsersRepository
import com.example.flow.domain.repository.UsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUsersRepository(dataSource: RemoteDataSource, dao: UsersDao): UsersRepository {
        return UsersRepositoryImpl(dataSource, dao)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: ReqresApi, dao: UsersDao, cacheMapper: CacheMapper): RemoteDataSource {
        return RemoteDataSourceImpl(api, dao, cacheMapper)
    }
}