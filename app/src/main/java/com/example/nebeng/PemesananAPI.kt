package com.example.nebeng

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface PemesananAPI {
    @GET("getpemesanan")
    fun getpemesanan(): Call<PemesananResponse>

    @POST("postpemesanan")
    fun postpemesanan(
        @Body pemesananRequest : NawarRequest
    ) : Call<NawarResponse>

    @GET
    fun getbyidpemesanan(
        @Url url : String,
    ) : Call<OncePemesananResponse>
}
