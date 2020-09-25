package com.sharmin.zsstestapp.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.sharmin.zsstestapp.authlistener.AuthListener
import com.sharmin.zsstestapp.data.UserRepository

class LoginViewModel : ViewModel() {

    var email:String?=null
    var password:String?=null
    var authListener:AuthListener?=null


    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
        authListener?.onFailure("Invaild password or email")
            return
        }
       //authListener?.onSuccess()

        //add userRepository//
        val loginResponse= UserRepository().userLogin(email!!,password!!)

        authListener?.onSuccess(loginResponse)


    }





}