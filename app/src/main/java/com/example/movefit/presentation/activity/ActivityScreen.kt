package pt.ipca.movefit.presentation.activity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pt.ipca.movefit.domain.model.Activity

/**
 * Ecrã para registar e visualizar atividades físicas.
 * Permite ao utilizador inserir dados e ver a lista de atividades registadas.
 *
 * @param navController Permite a navegação para outros ecrãs, mesmo que ainda não esteja a ser usado neste ecrã.
 * @param viewModel ViewModel responsável pela lógica de negócio e estado das atividades.
 */
@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = viewModel()
) {
    val atividade = viewModel.activityState
    val atividades = viewModel.userActivities

    // ✅ Carrega as atividades do utilizador ao entrar no ecrã
    LaunchedEffect(Unit) {
        viewModel.loadUserActivities()
    }

    // Layout do formulário de registo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Campo para o nome da atividade
        OutlinedTextField(
            value = atividade.nome,
            onValueChange = { viewModel.onActivityChanged(atividade.copy(nome = it)) },
            label = { Text("Nome da Atividade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para o tipo da atividade
        OutlinedTextField(
            value = atividade.tipo,
            onValueChange = { viewModel.onActivityChanged(atividade.copy(tipo = it)) },
            label = { Text("Tipo") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para duração em minutos
        OutlinedTextField(
            value = atividade.duracaoMinutos.toString(),
            onValueChange = {
                val minutos = it.toIntOrNull() ?: 0
                viewModel.onActivityChanged(atividade.copy(duracaoMinutos = minutos))
            },
            label = { Text("Duração (min)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para calorias
        OutlinedTextField(
            value = atividade.calorias.toString(),
            onValueChange = {
                val calorias = it.toIntOrNull() ?: 0
                viewModel.onActivityChanged(atividade.copy(calorias = calorias))
            },
            label = { Text("Calorias queimadas") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Botão para registar a atividade
        Button(
            onClick = { viewModel.registerActivity() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registar Atividade")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de atividades já registadas
        Text("Atividades registadas:", style = MaterialTheme.typography.titleMedium)
        atividades.forEach {
            Text("- ${it.nome} (${it.tipo} - ${it.duracaoMinutos} min, ${it.calorias} kcal)")
        }
    }
}