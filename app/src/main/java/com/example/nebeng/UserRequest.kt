package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("nis")
    @Expose
    var nis:String?=null

    @SerializedName("password")
    @Expose
    var password:String?=null
}
