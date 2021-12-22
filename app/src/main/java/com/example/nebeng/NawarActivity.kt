package com.example.nebeng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NawarActivity : AppCompatActivity() {
    lateinit var sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nawar_m)
        sharedpref = PreferencesHelper(this)
        supportActionBar?.hide()

        val alamat_tujuan : EditText = findViewById(R.id.alamatinp)
        val alamat_jemput : EditText = findViewById(R.id.temuinp)
        val total_bayar : EditText = findViewById(R.id.hargainp)
        val user_id : String? = sharedpref.getString(Constant.ID)
//        val harga : String = total_bayar.text.toString().trim()

        val nawar = NawarRequest()
        nawar.alamat_jemput = alamat_jemput.text.toString().trim()
        nawar.alamat_tujuan = alamat_tujuan.text.toString().trim()
        nawar.total_bayar = total_bayar.text.toString().trim()
        nawar.driver = user_id
        //benerin request pemesanan / sistem nawar
        val userbtn : Button = findViewById(R.id.nawarproceed)
        userbtn.setOnClickListener{
            val retro = Retro().getRetroClient().create(PemesananAPI::class.java)
            retro.postpemesanan(nawar).enqueue(object:Callback<NawarResponse>{
                override fun onResponse(
                    call: Call<NawarResponse>,
                    response: Response<NawarResponse>
                ) {
                    Toast.makeText(this@NawarActivity,"Membuat Penawaran Berhasil",Toast.LENGTH_SHORT)
                    startActivity(Intent(this@NawarActivity,Beranda::class.java))
                }

                override fun onFailure(call: Call<NawarResponse>, t: Throwable) {
                    Toast.makeText(this@NawarActivity,"Membuat Penawaran Gagal",Toast.LENGTH_SHORT)
                    startActivity(Intent(this@NawarActivity,Beranda::class.java))
                }

            })

        }
    }
}
