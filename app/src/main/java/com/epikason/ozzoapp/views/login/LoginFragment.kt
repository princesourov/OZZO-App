package com.epikason.ozzoapp.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.epikason.ozzoapp.R
import com.epikason.ozzoapp.databinding.FragmentLoginBinding
import com.epikason.ozzoapp.isEmpty

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding = FragmentLoginBinding.inflate(inflater, container, false)
        setListener()
        return binding.root
    }

    private fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etEmail.isEmpty() && !etPassword.isEmpty()){
                    Toast.makeText(context, "All input done...", Toast.LENGTH_LONG).show()
                }
            }
            btnRegister.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
            }
        }

    }


}