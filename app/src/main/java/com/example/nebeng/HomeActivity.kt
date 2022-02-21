package com.example.nebeng

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {
    lateinit var sharedpref : PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedpref = PreferencesHelper(this)
        supportActionBar?.hide()
//        val userbtn : Button = findViewById(R.id.btn_masuk)
//        userbtn.setOnClickListener{
////            val Intent = Intent(this, MainActivity::class.java)
////            startActivity(Intent)
//        }


        //saat oncreate jalankan function initAction()
        initAction()
    }
    //cek sudah login atau belum
    override fun onStart() {
        super.onStart()
        if(sharedpref.getBoolean(Constant.PREF_IS_LOGIN)){
            startActivity(Intent(this,Beranda::class.java))
            finish()
        }
        //tidak termasuk login ini dibuat ms untuk testing ke beranda
//        val i : Button = findViewById(R.id.testy)
//        i.setOnClickListener{
//            val Intent = Intent(this, Beranda::class.java)
//            startActivity(Intent)
//        }
    }

    fun initAction(){
        //Get BtnLogin By Id
        val btnLogin:Button = findViewById(R.id.btn_login)
        //Saat BtnLogin DiTekan
        btnLogin.setOnClickListener{
            login()
        }
    }

//    //login biasa
//    fun login(){
//        val nis_input : EditText = findViewById(R.id.inp_NIS)
//        val password_input : EditText = findViewById(R.id.inp_sandi)
//        Log.e("Status","Masuk")
//        if(nis_input.text.equals("user") && password_input.text.equals("user")){
//            val Intent = Intent(this, Beranda::class.java)
//            startActivity(Intent)
//        }
//    }


    fun login(){
        //Get Input Nis Dan Password
        val nis_input : EditText = findViewById(R.id.inp_NIS)
        val password_input : EditText = findViewById(R.id.inp_sandi)
        //Instance Model User Request yang akan dikirim ke http api request
        val request = UserRequest()
        request.nis = nis_input.text.toString().trim()
        request.password = password_input.text.toString().trim()



        Toast.makeText(applicationContext,"Mohon Tunggu",Toast.LENGTH_LONG).show()

        val retro = Retro().getRetroClient().create(UserAPI::class.java)
        retro.login(request).enqueue(object: Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
                //tinggal buat cara agar sukses login dan ke halaman beranda
                if(user!!.message == "Login Sukses"){
                    Toast.makeText(applicationContext,"Login Berhasil",Toast.LENGTH_SHORT).show()
                    sharedpref.put(Constant.PREF_NIS,user!!.data?.nis.toString())
                    sharedpref.put(Constant.PREF_PASSWORD,user!!.data?.password.toString())
                    sharedpref.put(Constant.PREF_IS_LOGIN,true)
                    //user data
                    sharedpref.put(Constant.ID,user!!.data?.id.toString())
                    sharedpref.put(Constant.NAMA_LENGKAP,user!!.data?.nama_lengkap.toString())
                    sharedpref.put(Constant.EMAIL,user!!.data?.email.toString())
                    sharedpref.put(Constant.NO_TELP,user!!.data?.no_telp.toString())
                    sharedpref.put(Constant.JENIS_KELAMIN,user!!.data?.jenis_kelamin.toString())

                    val intent = Intent(this@HomeActivity, Beranda::class.java)
//                    intent.put Extra("nama_lengkap",user!!.data?.nama_lengkap.toString())
//                    intent.putExtra("no_telp",user!!.data?.no_telp.toString())
//                    intent.putExtra("email",user!!.data?.email.toString())
                    startActivity(intent)
                }else{
                    Log.e("Message",user!!.message.toString())
                    Toast.makeText(applicationContext,"Login Gagal",Toast.LENGTH_SHORT).show()
                }

//                if(!response.code()){
//                    Toast.makeText(applicationContext,"Maaf Untuk Saat Ini,Sedang Maintenance",Toast.LENGTH_LONG).show()
//                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Login Error","Untuk Saat Ini Aplikasi Masih Maintenance")
                Toast.makeText(applicationContext,"Untuk Saat Ini Aplikasi Masih Maintenance",Toast.LENGTH_LONG).show()
            }

        })


    }
}
