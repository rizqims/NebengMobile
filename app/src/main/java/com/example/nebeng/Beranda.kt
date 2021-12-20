package com.example.nebeng

//import com.example.nebeng.ui.notifications.NotificationsFragment
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
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
    private lateinit var sharedpref: PreferencesHelper

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

//        val akunFrag : View = layoutInflater.inflate(R.layout.fragment_notifications, null)
//        val homeFrag : View = layoutInflater.inflate(R.layout.fragment_home, null)


        //beranda
        val textNama: TextView = findViewById(R.id.namaAkun)
        val textNoTelp: TextView = findViewById(R.id.noTelp)
        textNama.setText(sharedpref.getString(Constant.NAMA_LENGKAP))
        textNoTelp.setText(sharedpref.getString(Constant.NO_TELP))

//        Masih belum work, jangan disentuh
//        val textNamaProfile : TextView = findViewById(R.id.namaProfile)
//        val textEmailProfile : TextView = akunFrag.findViewById(R.id.emailAkun)
//        val textNoTelpProfile : TextView = akunFrag.findViewById(R.id.noAkun)
//        textNamaProfile.setText(Constant.NAMA_LENGKAP)
//        textEmailProfile.setText(Constant.EMAIL)
//        textNoTelpProfile.setText(Constant.NO_TELP)

        //nah ini buat tombol logout cuma ini kan tombol dari beranda bukan yang tombol keluar dari halaman profile
//        val logoutBtn: Button = findViewById(R.id.keluarbtn)
        val logoutBtn: Button = findViewById(R.id.Logoutbtn)
        logoutBtn.setOnClickListener {
            sharedpref.logout()
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val i: ImageButton = findViewById(R.id.Nebengbtn)
        i.setOnClickListener {
            val Intent = Intent(this, NebengM::class.java)
            startActivity(Intent)
        }

        val o: ImageButton = findViewById(R.id.Nawarbtn)
        o.setOnClickListener {
            val Intent = Intent(this, Nawar_M::class.java)
            startActivity(Intent)
        }
    }
}