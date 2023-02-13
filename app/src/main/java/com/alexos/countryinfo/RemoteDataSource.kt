package com.alexos.countryinfo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestCountiesApi {
    @GET("name/{name}")
    suspend fun getCountryName(@Path("name") cityName: String): List<Counrty>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://restcountries.com/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCountiesApi = retrofit.create(RestCountiesApi::class.java)