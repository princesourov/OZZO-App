package com.epikason.ozzoapp.data.repository

import com.epikason.ozzoapp.data.models.UserLogIn
import com.epikason.ozzoapp.data.models.UserRegistration
import com.epikason.ozzoapp.data.services.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository : AuthService {
    override fun userRegistration(user: UserRegistration): Task<AuthResult> {

        val jAuth = FirebaseAuth.getInstance()

        return jAuth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: UserLogIn ) : Task<AuthResult> {
        val sAuth = FirebaseAuth.getInstance()

        return sAuth.signInWithEmailAndPassword(user.email,user.password)
    }

    override fun createUser(user: UserRegistration) {
    }
}