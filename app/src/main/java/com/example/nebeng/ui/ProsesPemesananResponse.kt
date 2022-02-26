package com.example.nebeng.ui

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProsesPemesananResponse {
    @SerializedName("message")
    @Expose
    val message:String?=null

    @SerializedName("DataPemesanan")
    @Expose
    val prosespemesanan:List<ProsesPemesanan>?=null

    class ProsesPemesanan{
        @SerializedName("id")
        @Expose
        val id:String?=null

        @SerializedName("driver_id")
        @Expose
        val driverId : String?=null

        @SerializedName("pemesanan")
        @Expose
        val pemesanan : Pemesanan?=null

        class Pemesanan{
            @SerializedName("alamat_tujuan")
            @Expose
            val alamattujuan : String?=null

            @SerializedName("total_bayar")
            @Expose
            val harga : String?=null
        }

        @SerializedName("penumpang")
        @Expose
        val penumpang : Penumpang?=null

        class Penumpang{
            @SerializedName("nama_lengkap")
            @Expose
            val nama_penumpang : String?=null
        }
    }
}
