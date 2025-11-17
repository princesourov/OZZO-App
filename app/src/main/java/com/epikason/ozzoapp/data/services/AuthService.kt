package com.epikason.ozzoapp.data.services

import com.epikason.ozzoapp.data.models.UserRegistration
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun userRegistration(user: UserRegistration): Task<AuthResult>
    fun userLogin()
    fun createUser(user: UserRegistration)
}