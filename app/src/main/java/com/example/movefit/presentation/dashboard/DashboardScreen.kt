package pt.ipca.movefit.presentation.dashboard  // ✅ Corrigido

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Ecrã principal do Dashboard.
 * Mantém o layout; adiciona apenas estado local de pesquisa para evitar referências indefinidas.
 */
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = viewModel()
) {
    // Estados expostos pelo ViewModel
    val stats by viewModel.stats.collectAsState()
    val wearable by viewModel.wearableData.collectAsState()

    // Estado local para a pesquisa (substitui variáveis antes indefinidas)
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de pesquisa (mantido no layout; agora com estado local válido)
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Secção: Estatísticas de Atividade
        Text(text = "Estatísticas da Atividade Física", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Atividades realizadas: ${stats.totalAtividades}")
        Text(text = "Calorias queimadas: ${stats.totalCalorias}")
        Text(text = "Tempo total (min): ${stats.totalMinutos}")

        Spacer(modifier = Modifier.height(32.dp))

        // Secção: Dados do Wearable
        Text(text = "Dados do Dispositivo Wearable", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Passos: ${wearable.passos}")
        Text(text = "Calorias: ${wearable.calorias}")
        Text(text = "Batimentos cardíacos: ${wearable.batimentos}")
    }
}