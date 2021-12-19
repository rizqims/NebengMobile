package com.example.nebeng

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
//        val userbtn : Button = findViewById(R.id.btn_masuk)
//        userbtn.setOnClickListener{
////            val Intent = Intent(this, MainActivity::class.java)
////            startActivity(Intent)
//        }
        //saat oncreate jalankan function initAction()
        initAction()
    }

    fun initAction(){
        //Get BtnLogin By Id
        val btnLogin:Button = findViewById(R.id.btn_login)
        //Saat BtnLogin DiTekan
        btnLogin.setOnClickListener{
            login()
        }
    }

    //function login
    fun login(){
        //Get Input Nis Dan Password
        val nis_input : EditText = findViewById(R.id.inp_NIS)
        val password_input : EditText = findViewById(R.id.inp_sandi)
        //Instance Model User Request yang akan dikirim ke http api request
        val request = UserRequest()
        request.nis = nis_input.text.toString().trim()
        request.password = password_input.text.toString().trim()

        val i : Button = findViewById(R.id.nen)
        i.setOnClickListener{
            val Intent = Intent(this, Beranda::class.java)
            startActivity(Intent)
        }

        val retro = Retro().getRetroClient().create(UserAPI::class.java)
        retro.login(request).enqueue(object:Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
                //tinggal buat cara agar sukses login dan ke halaman beranda
                if(user!!.message == "Login Sukses"){
//                    Log.e("Message",user!!.message.toString())
//                    Log.e("Nama",user!!.data?.nama_lengkap.toString())
//                    Log.e("Nis",user!!.data?.nis.toString())
//                    Log.e("Password",user!!.data?.password.toString())
                    val intent = Intent(this@HomeActivity, Beranda::class.java)
                    startActivity(intent)

                }else{
                    Log.e("Message",user!!.message.toString())
                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Login Error",t.message.toString())
            }

        })


    }
}
