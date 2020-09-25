package com.sharmin.zsstestapp.authlistener

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted()
    fun onSuccess(loginResponse:LiveData<String>)
    fun onFailure(message:String)
}