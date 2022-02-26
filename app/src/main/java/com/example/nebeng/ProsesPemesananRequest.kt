package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProsesPemesananRequest {
    @SerializedName("pemesanan_id")
    @Expose
    var pemesanan_id : String?=null

    @SerializedName("driver_id")
    @Expose
    var idDriver : String?=null

    @SerializedName("penumpang_id")
    @Expose
    var idPenumpang : String?=null
}
