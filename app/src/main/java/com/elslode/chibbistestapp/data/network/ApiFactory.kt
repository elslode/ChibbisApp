package com.elslode.chibbistestapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val URL_CHIBBIS = "https://front-task.chibbistest.ru/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL_CHIBBIS)
        .build()

    val apiService = retrofit.create(ApiService::class.java)

}