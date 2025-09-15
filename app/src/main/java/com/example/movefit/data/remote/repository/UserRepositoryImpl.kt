package pt.ipca.movefit.data.remote.repository

import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import pt.ipca.movefit.domain.model.User
import pt.ipca.movefit.domain.repository.UserRepository

/**
 * Implementação do repositório de utilizadores.
 * Usa Firebase Realtime Database para armazenar e recuperar dados dos utilizadores.
 */
class UserRepositoryImpl : UserRepository {

    private val dbRef = FirebaseDatabase.getInstance().getReference("utilizadores")

    /**
     * Adiciona um utilizador ao Firebase.
     */
    override suspend fun addUser(user: User) {
        dbRef.child(user.id).setValue(user).await()
    }

    /**
     * Obtém todos os utilizadores guardados no Firebase.
     */
    override suspend fun getUsers(): List<User> {
        val snapshot = dbRef.get().await()
        return snapshot.children.mapNotNull { it.getValue(User::class.java) }
    }

    /**
     * Procura um utilizador pelo email no Firebase.
     */
    override suspend fun getUserByEmail(email: String): User? {
        val snapshot = dbRef.get().await()
        return snapshot.children
            .mapNotNull { it.getValue(User::class.java) }
            .firstOrNull { it.email == email }
    }
}