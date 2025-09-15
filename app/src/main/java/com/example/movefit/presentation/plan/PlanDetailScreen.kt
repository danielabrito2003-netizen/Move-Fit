package pt.ipca.movefit.presentation.plan

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.ipca.movefit.domain.model.Plan

/**
 * Ecrã que apresenta os detalhes do plano de treino gerado para o objetivo selecionado.
 *
 * @param viewModel ViewModel que fornece os dados do plano de treino.
 */
@Composable
fun PlanDetailScreen(
    viewModel: PlanViewModel = viewModel() // ✅ ViewModel injetado corretamente
) {
    val planos = viewModel.planos.collectAsState().value
    val objetivo = viewModel.objetivoEscolhido.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Plano para: ${objetivo.uppercase()}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        if (planos.isEmpty()) {
            Text(
                text = "Nenhum plano disponível.",
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            planos.forEach { plano ->
                PlanoCard(plano = plano)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

/**
 * Componente reutilizável que apresenta os detalhes de um plano de treino.
 *
 * @param plano Objeto com os dados do plano.
 */
@Composable
fun PlanoCard(plano: Plan) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Título: ${plano.titulo}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Objetivo: ${plano.objetivo}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Nível: ${plano.nivel}", style = MaterialTheme.typography.bodyLarge)
    }
}