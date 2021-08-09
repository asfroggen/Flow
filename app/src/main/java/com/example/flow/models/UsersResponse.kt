package com.example.flow.models

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    @SerializedName("page") var page : Int = -1,
    @SerializedName("per_page") var per_page : Int = -1,
    @SerializedName("total") var total : Int = -1,
    @SerializedName("total_pages") var total_pages : Int = -1,
    @SerializedName("data") var data : List<User> = emptyList(),
    @SerializedName("support") var support : Support
        )

data class User (
    @SerializedName("id") var id: Int = -1,
    @SerializedName("email") var email: String = "",
    @SerializedName("first_name") var name: String = "",
    @SerializedName("last_name") var lastName: String = "",
    @SerializedName("avatar") var avatar: String = ""
)

data class Support(
    @SerializedName("url") var url: String = "",
    @SerializedName("text") var text: String = ""
)

