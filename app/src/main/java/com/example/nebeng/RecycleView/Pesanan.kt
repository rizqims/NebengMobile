package com.example.nebeng.RecycleView

class Pesanan {
    private var alamat_jemput : String = ""
    private var alamat_tujuan : String = ""
    private var total_bayar : String = ""
    private var driver : String = ""
    private var iddriver : String = ""
    private var id : String = ""
    private var is_accept = ""

    constructor(alamat_jemput:String,alamat_tujuan:String,total_bayar:String,driver:String,id:String,iddriver:String,is_accept:String){
        this.alamat_jemput = alamat_jemput
        this.alamat_tujuan = alamat_tujuan
        this.total_bayar = total_bayar
        this.driver = driver
        this.id = id
        this.iddriver = iddriver
        this.is_accept = is_accept
    }

    //alamat jemput
    fun getAlamatJemput():String{
        return alamat_jemput
    }
    fun setAlamatJemput(alamat_jemput: String){
        this.alamat_jemput = alamat_jemput
    }

    //alamat tujuan
    fun getAlamatTujuan():String{
        return alamat_tujuan
    }
    fun setAlamatTujuan(alamat_tujuan: String){
        this.alamat_tujuan = alamat_tujuan
    }

    //total bayar / harga
    fun getHarga():String{
        return total_bayar
    }
    fun setHarga(total_bayar: String){
        this.total_bayar = total_bayar
    }

    //driver
    fun getDriver():String{
        return driver
    }
    fun setDriver(driver: String){
        this.driver = driver
    }

    //id
    fun getId():String{
        return id
    }
    fun setId(id: String){
        this.id = id
    }

    //iddriver
    fun getIdDriver():String{
        return iddriver
    }

    fun setIdDriver(iddriver:String){
        this.iddriver = iddriver
    }

    //status diterima atau tidak
    fun getIsAccept():String{
        return is_accept
    }

    fun setIsAccept(is_accept: String){
        this.is_accept = is_accept
    }


}
