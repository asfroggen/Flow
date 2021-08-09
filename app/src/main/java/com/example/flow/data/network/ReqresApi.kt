package com.example.flow.data.network

import com.example.flow.models.UsersResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReqresApi {

    @GET("users")
    suspend fun getUsers(): Response<UsersResponse>
}