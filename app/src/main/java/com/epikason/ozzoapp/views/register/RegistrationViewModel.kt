package com.epikason.ozzoapp.views.register

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.epikason.ozzoapp.data.models.UserRegistration
import com.epikason.ozzoapp.data.repository.AuthRepository

class RegistrationViewModel : ViewModel() {

    fun userRegistration(user: UserRegistration){
        val authService = AuthRepository()

        authService.userRegistration(user).addOnSuccessListener {

        }.addOnFailureListener {

        }


    }
}