package com.epikason.ozzoapp.views.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epikason.ozzoapp.core.DataState
import com.epikason.ozzoapp.data.models.UserRegistration
import com.epikason.ozzoapp.data.repository.AuthRepository

class RegistrationViewModel : ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegistration>>()
    val registrationResponse : LiveData<DataState<UserRegistration>> = _registrationResponse

    fun userRegistration(user: UserRegistration){

        _registrationResponse.postValue(DataState.Loading())

        val authService = AuthRepository()

        authService.userRegistration(user).addOnSuccessListener {
            _registrationResponse.postValue(DataState.Success(user))

        }.addOnFailureListener {error->
            _registrationResponse.postValue(DataState.Error("${error.message}"))
        }
    }


}