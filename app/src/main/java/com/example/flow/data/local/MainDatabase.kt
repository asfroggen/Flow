package com.example.flow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flow.models.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class MainDatabase: RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}