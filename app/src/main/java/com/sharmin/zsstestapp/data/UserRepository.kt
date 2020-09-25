package com.sharmin.zsstestapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {
   fun userLogin(email:String,password:String):LiveData<String>{

       val loginRespons=MutableLiveData<String>()

       UserApi().userLogin(email,password).enqueue(object : Callback<ResponseBody> {
           override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

               loginRespons.value = t.message

           }

           override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               if (response.isSuccessful) {
                   loginRespons.value = response.body()?.string()
               } else {

                   loginRespons.value = response.body()?.string()
               }

           }


       })


         return loginRespons

   }

}

