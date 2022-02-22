package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EditProfileRequest {
    @SerializedName("nama_lengkap")
    @Expose
    var nama_lengkap : String?=null

    @SerializedName("email")
    @Expose
    var email : String?=null

    @SerializedName("no_telp")
    @Expose
    var no_telp : String?=null

    @SerializedName("jenis_kelamin")
    @Expose
    var jenis_kelamin : String?=null
}
