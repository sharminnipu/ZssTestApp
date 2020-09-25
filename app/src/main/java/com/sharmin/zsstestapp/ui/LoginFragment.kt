package com.sharmin.zsstestapp.ui

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.sharmin.zsstestapp.R
import com.sharmin.zsstestapp.authlistener.toast
import com.sharmin.zsstestapp.authlistener.AuthListener

import com.sharmin.zsstestapp.databinding.LoginFragmentBinding

class LoginFragment : Fragment(),AuthListener {



    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    val binding:LoginFragmentBinding=DataBindingUtil.setContentView(requireActivity(),R.layout.login_fragment)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding.viewmodel=viewModel
        viewModel.authListener=this

    }

    override fun onStarted() {
        Toast.makeText(requireContext(),"Login Started",Toast.LENGTH_LONG).show()

    }

    override fun onSuccess(loginResponse:LiveData<String>) {
        loginResponse.observe(this, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

        })

    }

    override fun onFailure(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }

}