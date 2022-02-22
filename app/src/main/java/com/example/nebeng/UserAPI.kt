package com.example.nebeng

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface UserAPI {
    @POST("login")
    fun login(
        @Body userRequest:UserRequest
    ): Call<UserResponse>

    //system edit profile
    //dynamic url
    @POST
    fun editprofile(
        @Url url : String,
        @Body editprofile : EditProfileRequest
    ) : Call<EditProfileResponse>

}
