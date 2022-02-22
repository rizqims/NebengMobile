package com.example.nebeng

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.nebeng.helper.Constant
import com.example.nebeng.helper.PreferencesHelper
import com.example.nebeng.ui.notifications.NotificationsFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Editprofil : AppCompatActivity() {
    lateinit var sharedpref : PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofil)
        sharedpref = PreferencesHelper(this)
        supportActionBar?.hide()


        //button back
        val btnBackProfile : Button = findViewById(R.id.backprofil)
        btnBackProfile.setOnClickListener{
            val Intent = Intent(this, NotificationsFragment::class.java)
            startActivity(Intent)
        }
        onInit()
    }

    override fun onStart() {
        super.onStart()
        val nama_lengkap : EditText = findViewById(R.id.namauserinp)
        val email : EditText = findViewById(R.id.emailinp)
        val no_telp : EditText = findViewById(R.id.telpinp)
//        val radiolaki : RadioButton = findViewById(R.id.radioM)
//        val radioperempuan : RadioButton = findViewById(R.id.radioF)
        val radiogroup : RadioGroup = findViewById(R.id.radioGrp)

        nama_lengkap.setText(sharedpref.getString(Constant.NAMA_LENGKAP))
        email.setText(sharedpref.getString(Constant.EMAIL))
        no_telp.setText(sharedpref.getString(Constant.NO_TELP))
        if (sharedpref.getString(Constant.JENIS_KELAMIN) == "laki-laki"){
            radiogroup.check(R.id.radioM)
        }else if(sharedpref.getString(Constant.JENIS_KELAMIN) == "perempuan"){
            radiogroup.check(R.id.radioF)
        }else{
            radiogroup.clearCheck()
        }
    }

    fun onInit(){
        val btnEdit : Button = findViewById(R.id.btnedit)
        btnEdit.setOnClickListener{
            //get field
            val nama_lengkap : EditText = findViewById(R.id.namauserinp)
            val emailtxt : EditText = findViewById(R.id.emailinp)
            val no_telp : EditText = findViewById(R.id.telpinp)
            val radiolaki : RadioButton = findViewById(R.id.radioM)
            val radioperempuan : RadioButton = findViewById(R.id.radioF)
//            val radiogroup : RadioGroup = findViewById(R.id.radioGrp)

            //get text from field
            val nama : String = nama_lengkap.text.trim().toString()
            val email : String = emailtxt.text.trim().toString()
            val notelp : String = no_telp.text.trim().toString()
            val jenis_kelamin : String?

            if(radiolaki.isChecked){
                jenis_kelamin = "laki-laki"
            }else if(radioperempuan.isChecked){
                jenis_kelamin = "perempuan"
            }else{
                jenis_kelamin = null
            }

            val request = EditProfileRequest()
            request.nama_lengkap = nama
            request.email = email
            request.no_telp = notelp
            request.jenis_kelamin = jenis_kelamin

            val retro = Retro().getRetroClient().create(UserAPI::class.java)
            retro.editprofile("putuserdata/"+sharedpref.getString(Constant.ID),request).enqueue(object: Callback<EditProfileResponse>{
                override fun onResponse(
                    call: Call<EditProfileResponse>,
                    response: Response<EditProfileResponse>
                ) {
                    Log.e("Status",response.message().toString())
                    Toast.makeText(applicationContext,"Edit Profile Berhasil",Toast.LENGTH_SHORT).show()
                    sharedpref.put(Constant.NAMA_LENGKAP,nama)
                    sharedpref.put(Constant.EMAIL,email)
                    sharedpref.put(Constant.NO_TELP,notelp)
                    sharedpref.put(Constant.JENIS_KELAMIN,jenis_kelamin!!)
                }

                override fun onFailure(call: Call<EditProfileResponse>, t: Throwable) {
                    Toast.makeText(applicationContext,"Edit Profile Gagal",Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
}
