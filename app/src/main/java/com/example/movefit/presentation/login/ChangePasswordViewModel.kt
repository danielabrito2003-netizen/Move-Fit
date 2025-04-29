package pt.ipca.movefit.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChangePasswordViewModel : ViewModel() {

    var currentPassword = mutableStateOf("")
        private set

    var newPassword = mutableStateOf("")
        private set

    var confirmPassword = mutableStateOf("")
        private set

    fun updateCurrentPassword(value: String) {
        currentPassword.value = value
    }

    fun updateNewPassword(value: String) {
        newPassword.value = value
    }

    fun updateConfirmPassword(value: String) {
        confirmPassword.value = value
    }

    fun alterarPassword() {
        // TODO: lógica de validação e integração com Firebase Auth ou Room
    }
}