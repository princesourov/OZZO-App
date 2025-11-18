package com.epikason.ozzoapp.views.register

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
import com.epikason.ozzoapp.data.models.UserRegistration
import com.epikason.ozzoapp.databinding.FragmentRegisterBinding
import com.epikason.ozzoapp.isEmpty

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    private val viewModel : RegistrationViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setListener()
        registrationResponse()
        return binding.root
    }

    private fun setListener() {
        with(binding){
            btnRegister.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){
                    val user = UserRegistration(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "Seller",
                        ""
                    )

                    viewModel.userRegistration(user)
                }
            }
            btLogin.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment2,
                    null,
                    NavOptions
                        .Builder()
                        .setPopUpTo(R.id.registerFragment,true)
                        .build()
                )
            }
        }
    }
    private fun registrationResponse() {

        viewModel.registrationResponse.observe(viewLifecycleOwner){

            when(it) {
                is DataState.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(context, "Loading....", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment2,
                        null,
                        NavOptions
                            .Builder()
                            .setPopUpTo(R.id.registerFragment,true)
                            .build()
                    )

                }
            }
        }
    }
}
