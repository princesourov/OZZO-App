package com.epikason.ozzoapp.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epikason.ozzoapp.core.DataState
import com.epikason.ozzoapp.data.models.UserLogIn
import com.epikason.ozzoapp.data.models.UserRegistration
import com.epikason.ozzoapp.data.repository.AuthRepository

class LogInViewModel : ViewModel() {

    private val _logInResponse = MutableLiveData<DataState<UserLogIn>>()
    val logInResponse: LiveData<DataState<UserLogIn>> = _logInResponse

    fun userLogin(user: UserLogIn) {

        val authService = AuthRepository()

        _logInResponse.postValue(DataState.Loading())
        authService.userLogin(user).addOnSuccessListener {
            _logInResponse.postValue(DataState.Success(user))

        }.addOnFailureListener {
            _logInResponse.postValue(DataState.Error(it.message.toString()))

        }
    }
}