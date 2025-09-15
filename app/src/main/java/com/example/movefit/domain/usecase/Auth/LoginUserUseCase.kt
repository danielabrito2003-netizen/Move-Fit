package pt.ipca.movefit.domain.usecase.auth

import pt.ipca.movefit.domain.repository.AuthRepository

/**
 * Caso de uso para iniciar sessão de um utilizador.
 * Recebe o email e password e delega a lógica de autenticação ao AuthRepository.
 */
class LoginUserUseCase(
    private val authRepository: AuthRepository
) {
    /**
     * Executa a autenticação do utilizador com base no email e palavra-passe fornecidos.
     *
     * @param email Email do utilizador.
     * @param password Palavra-passe do utilizador.
     * @return Verdadeiro se a autenticação for bem-sucedida, falso caso contrário.
     */
    suspend operator fun invoke(email: String, password: String): Boolean {
        return authRepository.login(email, password)
    }
}
