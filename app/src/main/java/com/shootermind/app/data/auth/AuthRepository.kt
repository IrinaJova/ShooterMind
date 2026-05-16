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
}
