package com.example.nebeng

//import com.example.nebeng.ui.notifications.NotificationsFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nebeng.databinding.ActivityBerandaBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Beranda : AppCompatActivity() {

    private lateinit var binding: ActivityBerandaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)
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


        //berand


//        Masih belum work, jangan disentuh
//        val textNamaProfile : TextView = findViewById(R.id.namaProfile)
//        val textEmailProfile : TextView = akunFrag.findViewById(R.id.emailAkun)
//        val textNoTelpProfile : TextView = akunFrag.findViewById(R.id.noAkun)
//        textNamaProfile.setText(Constant.NAMA_LENGKAP)
//        textEmailProfile.setText(Constant.EMAIL)
//        textNoTelpProfile.setText(Constant.NO_TELP)

        //nah ini buat tombol logout cuma ini kan tombol dari beranda bukan yang tombol keluar dari halaman profile
//        val logoutBtn: Button = findViewById(R.id.keluarbtn)
//        val logoutBtn: Button = findViewById(R.id.Logoutbtn)
//        logoutBtn.setOnClickListener {
//            sharedpref.logout()
//            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, HomeActivity::class.java))
//        }
    }
}
