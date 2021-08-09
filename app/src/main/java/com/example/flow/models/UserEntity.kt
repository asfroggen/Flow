package com.example.flow.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity (
    var email: String = "",
    var name: String = "",
    var lastName: String = "",
    var avatar: String = "",
    @PrimaryKey
    var id: Int = -1
        )