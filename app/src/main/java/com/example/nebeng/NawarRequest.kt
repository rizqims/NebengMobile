package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NawarRequest {
    @SerializedName("alamat_jemput")
    @Expose
    var alamat_jemput:String?=null

    @SerializedName("alamat_tujuan")
    @Expose
    var alamat_tujuan:String?=null

    @SerializedName("total_bayar")
    @Expose
    var total_bayar:String?=null

    @SerializedName("user_id")
    @Expose
    var driver:String?=null


}
