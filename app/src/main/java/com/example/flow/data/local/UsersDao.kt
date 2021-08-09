package com.example.flow.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flow.models.UserEntity

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(subscription: UserEntity)

    @Query("SELECT * FROM users_table")
    suspend fun getUsers(): List<UserEntity>

}