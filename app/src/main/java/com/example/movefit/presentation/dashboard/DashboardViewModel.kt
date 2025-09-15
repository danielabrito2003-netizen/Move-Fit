package com.example.movefit.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pt.ipca.movefit.domain.model.Activity
import pt.ipca.movefit.domain.model.WearableData
import pt.ipca.movefit.domain.repository.AuthRepository
import pt.ipca.movefit.domain.usecase.activity.GetStatsUseCase
import pt.ipca.movefit.domain.usecase.wearable.SyncWearableDataUseCase

/**
 * ViewModel do Dashboard: agrega estatísticas de atividades (a partir da lista devolvida pelo caso de uso)
 * e dados de wearable para apresentação na UI, seguindo MVVM e Clean Architecture.
 */
class DashboardViewModel(
    private val getStatsUseCase: GetStatsUseCase,                 // Caso de uso: devolve List<Activity>
    private val syncWearableDataUseCase: SyncWearableDataUseCase, // Caso de uso: invoke(userId) -> WearableData?
    private val authRepository: AuthRepository                    // Repositório de autenticação (UID atual)
) : ViewModel() {

    // Estado com estatísticas agregadas para a UI (DTO próprio da apresentação)
    private val _stats = MutableStateFlow(ActivityStatsUi())
    val stats: StateFlow<ActivityStatsUi> = _stats

    // Estado com dados do wearable (estrutura do domínio: passos, calorias, batimentos)
    private val _wearableData = MutableStateFlow(
        WearableData(
            passos = 0,
            calorias = 0,
            batimentos = 0
        )
    )
    val wearableData: StateFlow<WearableData> = _wearableData

    init {
        carregarDashboard()
    }

    /**
     * Carrega dados para o dashboard:
     *  1) Obtém lista de atividades do utilizador (GetStatsUseCase)
     *  2) Agrega totais (nº atividades, soma das calorias, soma dos minutos)
     *  3) Obtém os dados mais recentes do wearable (SyncWearableDataUseCase.invoke(userId))
     */
    private fun carregarDashboard() {
        val userId = authRepository.getCurrentUserId() ?: return

        viewModelScope.launch {
            try {
                // 1) Lista de atividades do utilizador
                val atividades: List<Activity> = getStatsUseCase(userId)

                // 2) Agregação local das estatísticas
                val totalAtividades = atividades.size
                val totalCalorias = atividades.sumOf { it.calorias }.toFloat()
                val totalMinutos = atividades.sumOf { it.duracaoMinutos }

                _stats.value = ActivityStatsUi(
                    totalAtividades = totalAtividades,
                    totalCalorias = totalCalorias,
                    totalMinutos = totalMinutos
                )

                // 3) Dados de wearable (usa a sobrecarga correta: invoke(userId))
                val wearable = syncWearableDataUseCase(userId)
                if (wearable != null) _wearableData.value = wearable

            } catch (e: Exception) {
                e.printStackTrace() // logging simples
            }
        }
    }
}

/**
 * DTO de apoio para a UI do Dashboard (não expõe diretamente as classes de domínio).
 */
data class ActivityStatsUi(
    val totalAtividades: Int = 0,
    val totalCalorias: Float = 0f,
    val totalMinutos: Int = 0
)