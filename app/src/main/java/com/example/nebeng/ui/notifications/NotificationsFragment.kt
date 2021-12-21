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
import com.example.nebeng.R
import com.example.nebeng.databinding.FragmentNotificationsBinding
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var sharedpref : PreferencesHelper
    private var _binding: FragmentNotificationsBinding? = null

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
        sharedpref = PreferencesHelper(requireActivity())
        val TextNamaProfile : TextView = root.findViewById(R.id.namaProfile)
        val TextEmailProfile : TextView = root.findViewById(R.id.emailAkun)
        val TextNoTelp : TextView = root.findViewById(R.id.noAkun)
        //button logout
        val btnLogout : Button = root.findViewById(R.id.btnLogout)
        //button edit
        val btnEditProfile : Button = root.findViewById(R.id.editbtnn)

        TextNamaProfile.setText(sharedpref.getString(Constant.NAMA_LENGKAP))
        TextEmailProfile.setText(sharedpref.getString(Constant.EMAIL))
        TextNoTelp.setText(sharedpref.getString(Constant.NO_TELP))

        btnLogout.setOnClickListener{
            sharedpref.logout()
            Toast.makeText(requireActivity(), "Logout Berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
        }
        btnEditProfile.setOnClickListener{
            startActivity(Intent(requireActivity(),Editprofil::class.java))
        }

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
