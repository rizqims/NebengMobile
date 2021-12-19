package com.example.nebeng.helper

import android.content.Context
import android.content.SharedPreferences
//tempat untuk nyimpen data yang diambil dari api,dan ada session juga
class PreferencesHelper (context : Context) {
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

    fun logout(){
        editor.clear()
            .apply()
    }
}
