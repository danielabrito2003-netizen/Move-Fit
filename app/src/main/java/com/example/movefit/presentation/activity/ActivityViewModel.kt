package pt.ipca.movefit.presentation.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import pt.ipca.movefit.domain.model.Activity
import pt.ipca.movefit.domain.usecase.activity.GetStatsUseCase
import pt.ipca.movefit.domain.usecase.activity.RegisterActivityUseCase

/**
 * ViewModel responsável por gerir o estado e as ações do ecrã de Atividades.
 * Atua como ponte entre a camada de apresentação (UI) e a camada de domínio (casos de uso).
 */
class ActivityViewModel(
    private val registerActivityUseCase: RegisterActivityUseCase,
    private val getStatsUseCase: GetStatsUseCase
) : ViewModel() {

    // Estado da atividade preenchida pelo utilizador
    var activityState by mutableStateOf(
        Activity(
            userId = "",
            nome = "",
            tipo = "",
            duracaoMinutos = 0,
            calorias = 0
        )
    )
        private set

    // Lista de atividades do utilizador autenticado
    var userActivities by mutableStateOf<List<Activity>>(emptyList())
        private set

    /**
     * Atualiza o estado da atividade com novos dados vindos do formulário.
     */
    fun onActivityChanged(newActivity: Activity) {
        activityState = newActivity
    }

    /**
     * Regista a atividade atual na base de dados local (Room)
     * e no Firebase, através do caso de uso.
     * ⚠️ Garante que o userId autenticado é atribuído à atividade.
     */
    fun registerActivity() {
        viewModelScope.launch {
            val currentUserId = getCurrentUserId()
            if (currentUserId.isNotEmpty()) {
                val activityComUser = activityState.copy(userId = currentUserId)
                registerActivityUseCase(activityComUser)
                loadUserActivities() // Atualiza a lista após o registo
            }
        }
    }

    /**
     * Carrega todas as atividades do utilizador autenticado,
     * usando o caso de uso GetStatsUseCase.
     */
    fun loadUserActivities() {
        viewModelScope.launch {
            val currentUserId = getCurrentUserId()
            if (currentUserId.isNotEmpty()) {
                val atividades = getStatsUseCase(currentUserId)
                userActivities = atividades
            }
        }
    }
}

/**
 * Função utilitária para obter o ID do utilizador autenticado no Firebase.
 *
 * @return ID do utilizador atual ou string vazia se não estiver autenticado.
 */
private fun getCurrentUserId(): String {
    return FirebaseAuth.getInstance().currentUser?.uid ?: ""
}