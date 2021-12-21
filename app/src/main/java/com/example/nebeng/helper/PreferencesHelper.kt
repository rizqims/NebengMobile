package com.example.nebeng.helper

import android.content.Context
import android.content.SharedPreferences
import com.example.nebeng.Beranda
import com.example.nebeng.ui.notifications.NotificationsFragment

//tempat untuk nyimpen data yang diambil dari api,dan ada session juga
class PreferencesHelper(context: Context) {
    private val PREFS_NAME = "userdatapreference"
    private val sharedpref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedpref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
        editor  = sharedpref.edit()
    }

    //save data string
    fun put(key : String,value : String){
        editor.putString(key,value)
            .apply()
    }

    //get data string
    fun getString(key : String) : String?{
        return sharedpref.getString(key,null)
    }

    //save data boolean
    fun put(key : String,value : Boolean){
        editor.putBoolean(key,value)
            .apply()
    }

    //get data boolean
    fun getBoolean(key:String) : Boolean{
        return sharedpref.getBoolean(key,false)
    }

    fun put(key: String,value:Int){
        editor.putInt(key,value)
            .apply()
    }

    fun getInt(key: String) : Int{
        return sharedpref.getInt(key,0)
    }

    fun logout(){
        editor.clear()
            .apply()
    }
}
