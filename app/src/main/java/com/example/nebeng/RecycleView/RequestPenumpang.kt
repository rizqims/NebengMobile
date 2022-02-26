package com.example.nebeng.RecycleView

class RequestPenumpang {
    private var namaPenumpang:String = ""
    private var alamatTujuan:String = ""
    private var harga:String = ""

    constructor(namaPenumpang : String,alamatTujuan : String,harga : String){
        this.namaPenumpang = namaPenumpang
        this.alamatTujuan = alamatTujuan
        this.harga = harga
    }

    //nama penumpang
    fun getNamaPenumpang():String{
        return namaPenumpang
    }

    fun setNamaPenumpang(namaPenumpang: String){
        this.namaPenumpang = namaPenumpang
    }

    //alamat tujuan
    fun getAlamatTujuan():String{
        return alamatTujuan
    }

    fun setAlamatTujuan(alamatTujuan: String){
        this.alamatTujuan = alamatTujuan
    }

    //harga
    fun getHarga():String{
        return harga
    }

    fun setHarga(harga:String){
        this.harga = harga
    }
}
