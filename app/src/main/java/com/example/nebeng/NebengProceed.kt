package com.example.nebeng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NebengProceed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nebeng_proceed)
        supportActionBar?.hide()

        val id : String = intent.getStringExtra("IdPesanan").toString()
        val retro = Retro().getRetroClient().create(PemesananAPI::class.java)
        retro.getbyidpemesanan("getpemesanan/"+id).enqueue(object :
            Callback<OncePemesananResponse> {
            override fun onResponse(
                call: Call<OncePemesananResponse>,
                response: Response<OncePemesananResponse>
            ) {
                val namaDriver : TextView? = findViewById(R.id.namauserlbl)
                val alamat : TextView? = findViewById(R.id.alamat)
                val titikjemput : TextView? = findViewById(R.id.titiktemu)
                val kendaraan : TextView? = findViewById(R.id.kendaraan)
                val harga : TextView? = findViewById(R.id.harga)

                namaDriver!!.setText(response.body()!!.datapemesanan!!.driver!!.nama_lengkap.toString())
                alamat!!.setText(response.body()!!.datapemesanan!!.alamat_tujuan.toString())
                titikjemput!!.setText(response.body()!!.datapemesanan!!.alamat_jemput.toString())
                kendaraan!!.setText(if (response.body()!!.datapemesanan!!.driver!!.kendaraan != null) response.body()!!.datapemesanan!!.driver!!.kendaraan!!.type_kendaraan.toString()+" | " +response.body()!!.datapemesanan!!.driver!!.kendaraan!!.merk_kendaraan+" | "+response.body()!!.datapemesanan!!.driver!!.kendaraan!!.nomor_kendaraan else "Tidak Punya")
                harga!!.setText(response.body()!!.datapemesanan!!.total_bayar.toString())
            }

            override fun onFailure(call: Call<OncePemesananResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"Gagal Memuat", Toast.LENGTH_SHORT).show()
            }

        })

        val userbtn : Button = findViewById(R.id.Nebengok)
        userbtn.setOnClickListener{
            val Intent = Intent(this, ProgresNebeng::class.java)
            startActivity(Intent)
        }
    }

//    override fun onStart() {
//        super.onStart()
//
//
//    }
}
