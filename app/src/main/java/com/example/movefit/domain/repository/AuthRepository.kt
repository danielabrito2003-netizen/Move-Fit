package pt.ipca.movefit.domain.repository

/**
 * Interface responsável pela autenticação de utilizadores,
 * utilizando o Firebase Auth na camada de dados.
 */
interface AuthRepository {

    /**
     * Efetua o login com email e palavra-passe.
     * @return true se o login for bem-sucedido.
     */
    suspend fun login(email: String, password: String): Boolean

    /**
     * Regista um novo utilizador com email e palavra-passe.
     * @return true se o registo for bem-sucedido.
     */
    suspend fun register(email: String, password: String): Boolean

    /**
     * Termina a sessão atual.
     */
    suspend fun logout()

    /**
     * Verifica se há um utilizador autenticado.
     * @return true se estiver autenticado.
     */
    fun isUserLoggedIn(): Boolean

    /**
     * Obtém o ID do utilizador autenticado atual.
     * @return UID ou null se não autenticado.
     */
    fun getCurrentUserId(): String?
}