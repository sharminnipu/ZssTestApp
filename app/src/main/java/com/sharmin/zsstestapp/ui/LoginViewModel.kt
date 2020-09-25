package com.sharmin.zsstestapp.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.sharmin.zsstestapp.authlistener.AuthListener

class LoginViewModel : ViewModel() {

    var email:String?=null
    var password:String?=null
    var authListener:AuthListener?=null


    fun onLoginButtonClick(view: View){
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
      authListener?.onFailure("Invaild password or email")
            return
        }
       authListener?.onSuccess()

    }





}