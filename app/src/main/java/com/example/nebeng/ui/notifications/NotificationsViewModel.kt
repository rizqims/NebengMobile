package com.example.nebeng.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nebeng.Beranda
import com.example.nebeng.R

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = " "
    }
    val text: LiveData<String> = _text
}