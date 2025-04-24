package pt.ipca.movefit.presentation.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * ViewModel para o ecrã Dashboard (versão simplificada)
 */
class DashboardViewModel : ViewModel() {

    // Estado para a barra de pesquisa
    val searchQuery = mutableStateOf("")

    // Função para atualizar a query de pesquisa
    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }
}