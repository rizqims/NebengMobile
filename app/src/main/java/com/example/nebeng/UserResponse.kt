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
        @SerializedName("id")
        @Expose
        var id:Int?=null

        @SerializedName("nis")
        @Expose
        var nis:String?=null

        @SerializedName("nama_lengkap")
        @Expose
        var nama_lengkap:String?=null

        @SerializedName("email")
        @Expose
        var email:String?=null

        @SerializedName("password")
        @Expose
        var password:String?=null

        @SerializedName("no_telp")
        @Expose
        var no_telp:String?=null

        @SerializedName("jenis_kelamin")
        @Expose
        var jenis_kelamin:String?=null
    }
}
