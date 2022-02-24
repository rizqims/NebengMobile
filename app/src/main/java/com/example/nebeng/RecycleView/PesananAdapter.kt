package com.example.nebeng.RecycleView

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nebeng.NebengProceed
import com.example.nebeng.R

class PesananAdapter(val context: Context) : RecyclerView.Adapter<PesananAdapter.PesananViewHolder>() {

    private val pesan: MutableList<Pesanan> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesananViewHolder {
        return PesananViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PesananAdapter.PesananViewHolder, position: Int) {
        holder.bindmodel(pesan[position])
    }

    override fun getItemCount(): Int {
        return pesan.size
    }

    fun setPesanan(data: List<Pesanan>) {
        pesan.clear()
        pesan.addAll(data)
        notifyDataSetChanged()
    }

    inner class PesananViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val alamat_jemput: TextView? = item.findViewById(R.id.titikjemput)
        val alamat_tujuan: TextView? = item.findViewById(R.id.alamat)
        val total_bayar: TextView? = item.findViewById(R.id.harga)
        val driver: TextView? = item.findViewById(R.id.nama)
        val buttonNebeng: Button? = item.findViewById(R.id.NebengProceed)

        fun bindmodel(p: Pesanan) {
            alamat_jemput?.text = p.getAlamatJemput()
            alamat_tujuan?.text = p.getAlamatTujuan()
            total_bayar?.text = p.getHarga()
            driver?.text = p.getDriver()

            buttonNebeng!!.setOnClickListener {
                Log.e("IdPesanan: ",p.getId().toString())
                val intent = Intent(context, NebengProceed::class.java)
                intent.putExtra("IdPesanan",p.getId().toString())
                context.startActivity(intent)
            }
        }
    }
}
//            alamat_jemput.setText(p.getAlamatJemput())
//            alamat_tujuan.setText(p.getAlamatTujuan())
//            total_bayar.setText(p.getHarga())
//            driver.setText(p.ge
