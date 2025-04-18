package pt.ipca.movefit.presentation.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel responsável por manter o estado do ecrã de login.
 * Esta camada interage com os casos de uso da camada de domínio,
 * e mantém a lógica de negócio separada da UI.
 */
class LoginViewModel : ViewModel() {

    // Estado observável do campo de email
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    // Estado observável do campo de palavra-passe
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    /**
     * Atualiza o estado do campo de email
     */
    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    /**
     * Atualiza o estado do campo de palavra-passe
     */
    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    /**
     * Função que será usada no futuro para iniciar sessão com um caso de uso.
     */
    fun onLoginClicked() {
        // TODO: Implementar lógica de login com Firebase ou UseCase
    }

    /**
     * Função placeholder para enviar código de recuperação.
     * (a usar futuramente com Firebase/AuthUseCase)
     */
    fun onSendRecoveryCode(email: String) {
        // TODO: Enviar código de recuperação para o email
    }

    /**
     * Função placeholder para validar o código introduzido.
     */
    fun onValidateCode(code: String): Boolean {
        // TODO: Validar código introduzido pelo utilizador
        return true // temporário
    }

    /**
     * Função placeholder para definir nova palavra-passe.
     */
    fun onDefineNewPassword(newPassword: String, confirmPassword: String): Boolean {
        // TODO: Verificar se ambas as passwords coincidem e definir nova
        return newPassword == confirmPassword
    }
}