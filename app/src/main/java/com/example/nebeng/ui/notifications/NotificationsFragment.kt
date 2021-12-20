package com.example.nebeng.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nebeng.Editprofil
import com.example.nebeng.HomeActivity
import com.example.nebeng.NebengProceed
import com.example.nebeng.R
import com.example.nebeng.databinding.FragmentNotificationsBinding
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null


    private lateinit var sharedpref: PreferencesHelper


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        sharedpref = PreferencesHelper(requireActivity())


//        Monggo dicoba
        val textNamaProfile : TextView = root.findViewById(R.id.namaProfile)
        val textEmailProfile : TextView = root.findViewById(R.id.emailAkun)
        val textNoTelpProfile : TextView = root.findViewById(R.id.noAkun)
        textNamaProfile.setText(Constant.NAMA_LENGKAP).toString()
        textEmailProfile.setText(Constant.EMAIL).toString()
        textNoTelpProfile.setText(Constant.NO_TELP).toString()

//        Btn Logout
        val logoutBtn: Button = root.findViewById(R.id.keluarbtn)
        logoutBtn.setOnClickListener {
            sharedpref.logout()
            Toast.makeText(requireActivity(), "Logout Berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
        }

//        Btn Edit Profil
        val i : Button = root.findViewById(R.id.editbtnn)
        i.setOnClickListener {
            val i = Intent(requireActivity(), Editprofil::class.java)
            startActivity(i)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}