package pt.ipca.movefit.domain.usecase.auth

import pt.ipca.movefit.domain.repository.AuthRepository

/**
 * Caso de uso responsável por registar um novo utilizador.
 * Recebe o email e a palavra-passe e delega ao repositório a lógica de registo.
 */
class RegisterUserUseCase(
    private val authRepository: AuthRepository
) {
    /**
     * Executa o registo de um utilizador.
     *
     * @param email Email do utilizador.
     * @param password Palavra-passe do utilizador.
     * @return Booleano que indica se o registo foi bem-sucedido.
     */
    suspend operator fun invoke(email: String, password: String): Boolean {
        return authRepository.register(email, password)
    }
}