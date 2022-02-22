package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EditProfileResponse {
    @SerializedName("Message")
    @Expose
    var message:String?=null
}
