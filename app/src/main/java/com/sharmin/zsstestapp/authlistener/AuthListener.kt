package com.sharmin.zsstestapp.authlistener

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}