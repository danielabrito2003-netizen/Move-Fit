package pt.ipca.movefit.presentation.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.Exception

/**
 * ViewModel para o ecrã de registo
 * Responsável pela validação de formulário e lógica de registo
 */
class RegisterViewModel : ViewModel() {

    // Estados para os campos do formulário
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")
    val phone = mutableStateOf("")
    val birthDate = mutableStateOf("")
    val weight = mutableStateOf("")
    val height = mutableStateOf("")

    // Estado para mensagens de erro
    val errorMessage = mutableStateOf<String?>(null)

    // Estado de carregamento durante o registo
    val isLoading = mutableStateOf(false)

    // Funções para atualizar os estados
    fun updateEmail(value: String) {
        email.value = value
    }

    fun updatePassword(value: String) {
        password.value = value
    }

    fun updateConfirmPassword(value: String) {
        confirmPassword.value = value
    }

    fun updatePhone(value: String) {
        phone.value = value
    }

    fun updateBirthDate(value: String) {
        birthDate.value = value
    }

    fun updateWeight(value: String) {
        weight.value = value
    }

    fun updateHeight(value: String) {
        height.value = value
    }

    /**
     * Valida os campos do formulário de registo
     * @return true se todos os campos forem válidos, false caso contrário
     */
    private fun validateFields(): Boolean {
        // Validar email
        if (email.value.isEmpty() || !isValidEmail(email.value)) {
            errorMessage.value = "Email inválido"
            return false
        }

        // Validar password
        if (password.value.isEmpty() || password.value.length < 6) {
            errorMessage.value = "A palavra-passe deve ter pelo menos 6 caracteres"
            return false
        }

        // Validar confirmação de password
        if (password.value != confirmPassword.value) {
            errorMessage.value = "As palavras-passe não coincidem"
            return false
        }

        // Validar telemóvel
        if (phone.value.isEmpty() || !isValidPhone(phone.value)) {
            errorMessage.value = "Número de telemóvel inválido"
            return false
        }

        // Validar data de nascimento
        if (birthDate.value.isEmpty() || !isValidDate(birthDate.value)) {
            errorMessage.value = "Data de nascimento inválida"
            return false
        }

        // Validar peso
        if (weight.value.isEmpty() || !isValidWeight(weight.value)) {
            errorMessage.value = "Peso inválido"
            return false
        }

        // Validar altura
        if (height.value.isEmpty() || !isValidHeight(height.value)) {
            errorMessage.value = "Altura inválida"
            return false
        }

        // Todos os campos são válidos
        return true
    }

    /**
     * Processa o registo do utilizador
     * @param onSuccess callback a ser chamado em caso de sucesso
     */
    fun register(onSuccess: () -> Unit) {
        // Primeiro valida os campos
        if (!validateFields()) return

        isLoading.value = true

        try {
            // Em um projeto real, aqui seria a chamada ao usecase de registo
            // Exemplo: registerUserUseCase(email.value, password.value, ...)

            // Por enquanto, simulamos um registo bem-sucedido após 1 segundo
            // Numa implementação real, este código seria substituído pela chamada ao repositório
            android.os.Handler().postDelayed({
                isLoading.value = false
                onSuccess()
            }, 1000)

        } catch (e: Exception) {
            isLoading.value = false
            errorMessage.value = "Erro ao registar: ${e.message}"
        }
    }

    // Funções de validação auxiliares

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPhone(phone: String): Boolean {
        // Validação simples para número de telemóvel português (9 dígitos)
        return phone.length == 9 && phone.all { it.isDigit() }
    }

    private fun isValidDate(date: String): Boolean {
        // Validação simples no formato DD/MM/AAAA
        val regex = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d\$")
        return regex.matches(date)
    }

    private fun isValidWeight(weight: String): Boolean {
        return try {
            val weightValue = weight.toFloat()
            weightValue > 0 && weightValue < 500 // Em kg
        } catch (e: Exception) {
            false
        }
    }

    private fun isValidHeight(height: String): Boolean {
        return try {
            val heightValue = height.toFloat()
            heightValue > 0 && heightValue < 300 // Em cm
        } catch (e: Exception) {
            false
        }
    }
}