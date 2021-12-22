package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NawarResponse {
    @SerializedName("message")
    @Expose
    var message:String?=null
}
