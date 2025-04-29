package pt.ipca.movefit.presentation.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EditProfileViewModel : ViewModel() {

    var name = mutableStateOf("")
        private set

    var email = mutableStateOf("")
        private set

    var phone = mutableStateOf("")
        private set

    var weight = mutableStateOf("")
        private set

    var height = mutableStateOf("")
        private set

    fun updateName(value: String) {
        name.value = value
    }

    fun updateEmail(value: String) {
        email.value = value
    }

    fun updatePhone(value: String) {
        phone.value = value
    }

    fun updateWeight(value: String) {
        weight.value = value
    }

    fun updateHeight(value: String) {
        height.value = value
    }

    fun guardarAlteracoes() {
        // TODO: Guardar dados no Room ou Firebase
    }
}
