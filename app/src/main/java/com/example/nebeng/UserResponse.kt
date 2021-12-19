package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("Message")
    @Expose
    var message:String?=null
    @SerializedName("Data")
    @Expose
    var data:User?=null

    class User{
        @SerializedName("nis")
        @Expose
        var nis:String?=null

        @SerializedName("nama_lengkap")
        @Expose
        var nama_lengkap:String?=null

        @SerializedName("password")
        @Expose
        var password:String?=null
    }
}
