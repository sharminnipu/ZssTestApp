package com.sharmin.zsstestapp.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface EventApi {

   // @POST("user")
  //  suspend fun loginUser():Response

@GET("RecruitmentTest.json")
suspend fun getResource():Response<Resource>



    companion object{
        operator fun invoke() : EventApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dhaka-static.zssbd.com/")
                .build()
                .create(EventApi::class.java)
        }
    }




}