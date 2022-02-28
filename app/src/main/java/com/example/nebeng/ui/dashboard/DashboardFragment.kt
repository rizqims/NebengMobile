package com.example.nebeng.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nebeng.PemesananAPI
import com.example.nebeng.R
import com.example.nebeng.RecycleView.RequestPenumpang
import com.example.nebeng.RecycleView.RequestPenumpangAdapter
import com.example.nebeng.Retro
import com.example.nebeng.databinding.FragmentDashboardBinding
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper
import com.example.nebeng.ui.ProsesPemesananResponse
import kotlinx.android.synthetic.main.fragment_dashboard.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var requestPenumpangAdapter : RequestPenumpangAdapter
    lateinit var sharedpref : PreferencesHelper
    val lm = LinearLayoutManager(activity)
    val addRequestPenumpangList : MutableList<RequestPenumpang> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard,container,false)
//        dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)
//
//        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//
//
//        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun initView(){
        requestPenumpang.layoutManager = lm
        requestPenumpangAdapter = RequestPenumpangAdapter(requireActivity())
        requestPenumpang.adapter = requestPenumpangAdapter
        sharedpref = PreferencesHelper(this.requireContext())

        val retro = Retro().getRetroClient().create(PemesananAPI::class.java)
        retro.getprosespemesanan().enqueue(object: Callback<ProsesPemesananResponse>{
            override fun onResponse(
                call: Call<ProsesPemesananResponse>,
                response: Response<ProsesPemesananResponse>
            ) {
                val prosespemesanan = response.body()

                for(j in prosespemesanan?.prosespemesanan!!){
                    if(j.driverId == sharedpref.getString(Constant.ID)){
                        addRequestPenumpangList.add(RequestPenumpang(j.penumpang?.nama_penumpang!!,j.pemesanan?.alamattujuan!!,j.pemesanan?.harga!!))
                    }
                }

                requestPenumpangAdapter.setRequestPenumpang(addRequestPenumpangList)
            }

            override fun onFailure(call: Call<ProsesPemesananResponse>, t: Throwable) {
                Log.e("Error",t.message.toString())
            }

        })

    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}
