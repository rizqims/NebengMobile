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

        @SerializedName("driver")
        @Expose
        var driver:Driver?=null

        class Driver{
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

            @SerializedName("no_telp")
            @Expose
            var no_telp:String?=null

            @SerializedName("jenis_kelamin")
            @Expose
            var jenis_kelamin:String?=null

            @SerializedName("rating")
            @Expose
            var rating:String?=null
        }

    }
}
