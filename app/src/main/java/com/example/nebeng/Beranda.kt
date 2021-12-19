package com.example.nebeng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nebeng.databinding.ActivityBerandaBinding
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class Beranda : AppCompatActivity() {

    private lateinit var binding: ActivityBerandaBinding
    private lateinit var sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedpref = PreferencesHelper(this)
        supportActionBar?.hide()
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_beranda)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //beranda
        val textNama : TextView = findViewById(R.id.namaAkun)
        val textNoTelp : TextView = findViewById(R.id.noTelp)
        textNama.setText(sharedpref.getString(Constant.NAMA_LENGKAP))
        textNoTelp.setText(sharedpref.getString(Constant.NO_TELP))

        //nah ini saya mau nampilin data dihalaman profile cuma error katanya kan beda fragment
        //sedangkan yg ini fragment beranda / fragment home
        //profile
//        val textNamaProfile : TextView = findViewById(R.id.namaProfile)
//        val textEmailProfile : TextView = findViewById(R.id.emailAkun)
//        val textNoTelpProfile : TextView = findViewById(R.id.noAkun)
//        textNamaProfile.setText(Constant.NAMA_LENGKAP)
//        textEmailProfile.setText(Constant.EMAIL)
//        textNoTelpProfile.setText(Constant.NO_TELP)

        //nah ini buat tombol logout cuma ini kan tombol dari beranda bukan yang tombol keluar dari halaman profile
        val logoutBtn : Button = findViewById(R.id.Logoutbtn)
        logoutBtn.setOnClickListener{
            sharedpref.logout()
            Toast.makeText(this,"Logout Berhasil",Toast.LENGTH_SHORT)
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
    //baru sampe session selesai,logout selesai tinggal cari tau ambil textview dari fragment
}
