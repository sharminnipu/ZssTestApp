package com.sharmin.zsstestapp.data

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {


    @FormUrlEncoded
    @POST("user")
     fun userLogin(
        @Field ("email") email:String,
        @Field("password") password:String
    ): Call<ResponseBody>



    companion object{
        operator fun invoke() : UserApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("182.160.97.214:81/api/v1/")
                .build()
                .create(UserApi::class.java)
        }
    }


}