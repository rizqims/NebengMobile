package com.example.nebeng.RecycleView

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nebeng.R

class RequestPenumpangAdapter(val context:Context):RecyclerView.Adapter<RequestPenumpangAdapter.RequestPenumpangViewHolder>() {

    private val requestpenumpang : MutableList<RequestPenumpang> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestPenumpangViewHolder {
        return RequestPenumpangViewHolder(LayoutInflater.from(context).inflate(R.layout.konfirneb,parent,false))
    }

    override fun onBindViewHolder(holder: RequestPenumpangAdapter.RequestPenumpangViewHolder, position: Int) {
        holder.bindmodel(requestpenumpang[position])
    }

    override fun getItemCount(): Int {
        return requestpenumpang.size
    }

    fun setRequestPenumpang(data: List<RequestPenumpang>){
        requestpenumpang.clear()
        requestpenumpang.addAll(data)
        notifyDataSetChanged()
    }

    inner class RequestPenumpangViewHolder(item: View):RecyclerView.ViewHolder(item){

        val txtPenumpang : TextView = item.findViewById(R.id.nama)
        val txtAlamatTujuan : TextView = item.findViewById(R.id.alamat)
        val txtHarga : TextView = item.findViewById(R.id.hargarequest)
        val btnAccpet : ImageButton = item.findViewById(R.id.accept)
        val btnDecline : ImageButton = item.findViewById(R.id.decline)

        fun bindmodel(r:RequestPenumpang){
            txtPenumpang.text = r.getNamaPenumpang()
            txtAlamatTujuan.text = r.getAlamatTujuan()
            txtHarga.text = r.getHarga()

            btnAccpet.setOnClickListener {

            }

            btnDecline.setOnClickListener {
                Log.e("Tolak","Masuk")
            }
        }
    }
}
