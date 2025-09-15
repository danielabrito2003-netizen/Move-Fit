package pt.ipca.movefit.domain.repository

import pt.ipca.movefit.domain.model.User

/**
 * Interface que define as operações de acesso aos dados do Utilizador.
 * Utilizada pela camada de domínio para manter independência das fontes de dados.
 */
interface UserRepository {

    /**
     * Adiciona um novo utilizador ao sistema.
     */
    suspend fun addUser(user: User)

    /**
     * Obtém a lista completa de utilizadores.
     */
    suspend fun getUsers(): List<User>

    /**
     * Procura um utilizador pelo seu email.
     */
    suspend fun getUserByEmail(email: String): User?
}