package pt.ipca.movefit.data.remote.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import pt.ipca.movefit.domain.repository.AuthRepository

/**
 * Implementação do AuthRepository que usa o Firebase Auth
 * para realizar operações de autenticação.
 */
class AuthRepositoryImpl : AuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    /**
     * Efetua o login com email e palavra-passe.
     */
    override suspend fun login(email: String, password: String): Boolean {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Regista um novo utilizador.
     */
    override suspend fun register(email: String, password: String): Boolean {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Termina a sessão atual (logout).
     */
    override suspend fun logout() {
        firebaseAuth.signOut()
    }

    /**
     * Verifica se há um utilizador autenticado.
     */
    override fun isUserLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    /**
     * Obtém o UID do utilizador autenticado.
     */
    override fun getCurrentUserId(): String? {
        return firebaseAuth.currentUser?.uid
    }
}