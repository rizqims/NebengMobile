package com.example.nebeng

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PemesananResponse {
    @SerializedName("message")
    @Expose
    var message:String?=null

    @SerializedName("DataPemesanan")
    @Expose
    var datapemesanan: List<Pemesanan>?=null

    class Pemesanan{
        @SerializedName("id")
        @Expose
        var id:Int?=null

        @SerializedName("alamat_jemput")
        @Expose
        var alamat_jemput:String?=null

        @SerializedName("alamat_tujuan")
        @Expose
        var alamat_tujuan:String?=null

        @SerializedName("tanggal_pembatalan")
        @Expose
        var tanggal_pembatalan:String?=null

        @SerializedName("tanggal_pemesanan")
        @Expose
        var tanggal_pemesanan:String?=null

        @SerializedName("total_bayar")
        @Expose
        var total_bayar:String?=null

    }
}
