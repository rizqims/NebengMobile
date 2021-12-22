package com.example.nebeng

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nebeng.RecycleView.Pesanan
import com.example.nebeng.RecycleView.PesananAdapter
import kotlinx.android.synthetic.main.activity_nebeng_m.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//masih belum jalan untuk nampilin data ke halaman nebeng
class NebengActivity : AppCompatActivity() {

    lateinit var pesanAdapter : PesananAdapter
    val lm = LinearLayoutManager(this)
    val addpesanlist : MutableList<Pesanan> = ArrayList()



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

                listView.layoutManager = lm
                pesanAdapter = PesananAdapter(this@NebengActivity)
                listView.adapter = pesanAdapter

                for(i in pesan?.datapemesanan!!){
                    addpesanlist.add(Pesanan(i.alamat_jemput.toString(),i.alamat_tujuan.toString(),i.total_bayar.toString(),i.driver!!.nama_lengkap.toString()))
                }
//                addpesanlist.add(Pesanan("Soreang","SMKN 1 Katapang","20.000","Asep"))
//                addpesanlist.add(Pesanan("Soreang","SMKN 1 Katapang","20.000","Asep"))
//                addpesanlist.add(Pesanan("Soreang","SMKN 1 Katapang","20.000","Asep"))
//                addpesanlist.add(Pesanan("Soreang","SMKN 1 Katapang","20.000","Asep"))
//                addpesanlist.add(Pesanan("Soreang","SMKN 1 Katapang","20.000","Asep"))
                pesanAdapter.setPesanan(addpesanlist)
//                Log.e("Context",pesanAdapter.context.toString())
            }

            override fun onFailure(call: Call<PemesananResponse>, t: Throwable) {
                Log.e("Error",t.message.toString())
            }

        } )
    }
}
