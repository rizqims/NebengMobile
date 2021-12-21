package com.example.nebeng

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//masih belum jalan untuk nampilin data ke halaman nebeng
class NebengActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nebeng_m)
        initAction()
    }

    fun initAction(){
        val retro = Retro().getRetroClient().create(PemesananAPI::class.java)
        retro.getpemesanan().enqueue(object: Callback<PemesananResponse>{
            override fun onResponse(
                call: Call<PemesananResponse>,
                response: Response<PemesananResponse>
            ) {
                val pesan = response.body()
                for(i in pesan?.datapemesanan!!){
                    Log.e("Alamat Jemput",i.alamat_jemput.toString())
                }
            }

            override fun onFailure(call: Call<PemesananResponse>, t: Throwable) {
                Log.e("Message",t.message.toString())
            }

        } )
    }
}
