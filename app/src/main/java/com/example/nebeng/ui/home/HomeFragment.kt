package com.example.nebeng.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nebeng.Nawar_M
import com.example.nebeng.NebengActivity
import com.example.nebeng.NebengM
import com.example.nebeng.R
import com.example.nebeng.databinding.FragmentHomeBinding
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var sharedpref : PreferencesHelper
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        sharedpref = PreferencesHelper(requireActivity())

        val textNama: TextView = root.findViewById(R.id.namaAkun)
        val textNoTelp: TextView = root.findViewById(R.id.noTelp)
        textNama.setText(sharedpref.getString(Constant.NAMA_LENGKAP)).toString()
        textNoTelp.setText(sharedpref.getString(Constant.NO_TELP)).toString()

        val i: ImageButton = root.findViewById(R.id.Nebengbtn)
        i.setOnClickListener {
            val Intent = Intent(requireActivity(), NebengM::class.java)
            startActivity(Intent)
        }

        val o: ImageButton = root.findViewById(R.id.Nawarbtn)
        o.setOnClickListener {
            val Intent = Intent(requireActivity(), Nawar_M::class.java)
            startActivity(Intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}