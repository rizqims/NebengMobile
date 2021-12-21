package com.example.nebeng

import retrofit2.Call
import retrofit2.http.GET

interface PemesananAPI {
    @GET("getpemesanan")
    fun getpemesanan(): Call<PemesananResponse>
}
