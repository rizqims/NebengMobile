package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ChangePasswordResponse {
    @SerializedName("message")
    @Expose
    val message : String?=null
}
