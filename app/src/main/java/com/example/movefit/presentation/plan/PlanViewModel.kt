package pt.ipca.movefit.presentation.plan

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PlanViewModel : ViewModel() {

    // Estado interno privado (imutável externamente)
    private val _objetivoEscolhido = mutableStateOf<String?>(null)

    // Estado público que o ecrã pode observar
    val objetivoEscolhido: State<String?> = _objetivoEscolhido

    // Função para atualizar o objetivo
    fun escolherObjetivo(objetivo: String) {
        _objetivoEscolhido.value = objetivo
    }
}