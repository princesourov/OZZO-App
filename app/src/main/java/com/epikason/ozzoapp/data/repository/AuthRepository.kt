package com.epikason.ozzoapp.data.repository

import com.epikason.ozzoapp.core.Nodes
import com.epikason.ozzoapp.data.models.UserLogIn
import com.epikason.ozzoapp.data.models.UserRegistration
import com.epikason.ozzoapp.data.services.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject

class AuthRepository @Inject constructor(
    private val qAuth: FirebaseAuth,
    private val db: FirebaseFirestore
) : AuthService {

    override fun userRegistration(user: UserRegistration): Task<AuthResult> {

        return qAuth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: UserLogIn): Task<AuthResult> {

        return qAuth.signInWithEmailAndPassword(user.email, user.password)
    }

    override fun createUser(user: UserRegistration): Task<Void> {

        return db.collection(Nodes.USER).document(user.userID).set(user)
    }
}