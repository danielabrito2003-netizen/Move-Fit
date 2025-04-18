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
     * Atualiza o estado do email sempre que o utilizador altera o campo.
     */
    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    /**
     * Atualiza o estado da palavra-passe sempre que o utilizador altera o campo.
     */
    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    /**
     * Função a ser usada quando o botão de iniciar sessão for clicado.
     * Aqui será adicionada a lógica de autenticação mais tarde.
     */
    fun onLoginClicked() {
        // TODO: Implementar lógica de login com use case
    }
}
