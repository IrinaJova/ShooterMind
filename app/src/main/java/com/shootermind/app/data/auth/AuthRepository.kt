package com.shootermind.app.data.auth

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    suspend fun signInAnonymously(): Result<Unit> {
        return runCatching {
            firebaseAuth.signInAnonymously().await()
        }.map { }
    }

    suspend fun signInWithEmail(
        email: String,
        password: String
    ): Result<Unit> {
        return runCatching {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
        }.map { }
    }

    suspend fun registerWithEmail(
        email: String,
        password: String
    ): Result<Unit> {
        return runCatching {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        }.map { }
    }
}
