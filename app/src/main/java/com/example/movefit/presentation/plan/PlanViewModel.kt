package pt.ipca.movefit.presentation.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pt.ipca.movefit.domain.model.Plan
import pt.ipca.movefit.MyApplication

/**
 * ViewModel responsável por gerir o estado relacionado com os planos de treino.
 * Comunica com o caso de uso [GeneratePlanUseCase] para obter e guardar planos.
 */
class PlanViewModel : ViewModel() {

    // Fluxo que guarda a lista de planos gerados
    private val _planos = MutableStateFlow<List<Plan>>(emptyList())
    val planos: StateFlow<List<Plan>> = _planos

    // Estado que guarda o objetivo escolhido pelo utilizador
    private val _objetivoEscolhido = MutableStateFlow("")
    val objetivoEscolhido: StateFlow<String> = _objetivoEscolhido

    /**
     * Define o objetivo escolhido pelo utilizador.
     */
    fun escolherObjetivo(objetivo: String) {
        _objetivoEscolhido.value = objetivo
    }

    /**
     * Gera e guarda um plano de treino com base no objetivo recebido.
     */
    fun gerarPlano(objetivo: String) {
        viewModelScope.launch {
            val plano = Plan(
                id = System.currentTimeMillis().toString(), // ✅ Agora compatível
                titulo = "Plano para $objetivo",
                objetivo = objetivo,
                nivel = "Intermédio"
            )

            MyApplication.generatePlanUseCase.execute(plano)
            carregarPlanos()
        }
    }

    /**
     * Carrega todos os planos existentes da base de dados local.
     */
    fun carregarPlanos() {
        viewModelScope.launch {
            val lista = MyApplication.generatePlanUseCase.obterPlanos()
            _planos.value = lista
        }
    }
}