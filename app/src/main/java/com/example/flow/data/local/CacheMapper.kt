package com.example.flow.data.local

import com.example.flow.models.User
import com.example.flow.models.UserEntity
import com.example.flow.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject constructor(): EntityMapper<UserEntity, User>{
    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            id = entity.id,
            email = entity.email,
            name = entity.name,
            lastName = entity.lastName,
            avatar = entity.avatar
        )
    }

    override fun mapToEntity(domainModel: User): UserEntity {
        return UserEntity(
            id = domainModel.id,
            email = domainModel.email,
            name = domainModel.name,
            lastName = domainModel.lastName,
            avatar = domainModel.avatar
        )
    }

    fun mapFromEntityList(entities: List<UserEntity>): List<User>{
        return entities.map { mapFromEntity(it) }
    }
}