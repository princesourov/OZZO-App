package com.epikason.ozzoapp.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.epikason.ozzoapp.R
import com.epikason.ozzoapp.core.DataState
import com.epikason.ozzoapp.data.models.UserLogIn
import com.epikason.ozzoapp.databinding.FragmentLoginBinding
import com.epikason.ozzoapp.isEmpty

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val viewModel : LogInViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding = FragmentLoginBinding.inflate(inflater, container, false)
        setListener()
        logInResponse()
        return binding.root
    }


    private fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etEmail.isEmpty() && !etPassword.isEmpty()){
                    var user = UserLogIn(etEmail.text.toString(), etPassword.text.toString())

                    viewModel.userLogin(user)
                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.loginFragment, true)
                        .build()
                )
            }

        }

    }
    private fun logInResponse() {
        viewModel.logInResponse.observe(viewLifecycleOwner){
            when (it){
                is DataState.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(context, "Loading....", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    Toast.makeText(context, "LogIn Successful", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment,
                        null,
                        NavOptions.Builder()
                            .setPopUpTo(R.id.loginFragment,true)
                            .build()
                    )
            }
        }


    }
    }
}