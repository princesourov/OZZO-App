package com.epikason.ozzoapp.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.epikason.ozzoapp.R
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
        return binding.root
    }

    private fun setListener() {
        with(binding){
            btnRegister.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){
                    Toast.makeText(context, "All input done...", Toast.LENGTH_SHORT).show()

                    val user = UserRegistration(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "Seller",
                        ""
                    )

                    viewModel.userRegistration(user)
                }
                btLogin.setOnClickListener {
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)
                }
            }
        }
    }

}