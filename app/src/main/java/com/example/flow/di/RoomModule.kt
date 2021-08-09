package com.example.flow.di

import android.content.Context
import androidx.room.Room
import com.example.flow.data.local.MainDatabase
import com.example.flow.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideUsersDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MainDatabase::class.java,
        Constants.ROOM_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDAO(db: MainDatabase) = db.getUsersDao()
}