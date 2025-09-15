package pt.ipca.movefit.presentation.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.ipca.movefit.R

/**
 * Ecrã principal de seleção de planos de treino por objetivo.
 */
@Composable
fun PlanScreen(
    viewModel: PlanViewModel = viewModel() // ✅ ViewModel injetado corretamente
) {
    val objetivoEscolhido by viewModel.objetivoEscolhido.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Escolhe o teu objetivo",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Cartão para "Perder Peso"
        ObjetivoCard(
            titulo = "Perder Peso",
            imagem = R.drawable.perderpeso, // ✅ Corrigido para imagem existente
            onClick = {
                viewModel.escolherObjetivo("perder_peso")
                viewModel.gerarPlano("perder_peso")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Cartão para "Ganhar Massa"
        ObjetivoCard(
            titulo = "Ganhar Massa",
            imagem = R.drawable.ganharmassa, // ✅ Corrigido para imagem existente
            onClick = {
                viewModel.escolherObjetivo("ganhar_massa")
                viewModel.gerarPlano("ganhar_massa")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Cartão para "Resistência"
        ObjetivoCard(
            titulo = "Resistência",
            imagem = R.drawable.resistencia, // ✅ Assumido correto (já existe no print)
            onClick = {
                viewModel.escolherObjetivo("resistencia")
                viewModel.gerarPlano("resistencia")
            }
        )
    }
}

/**
 * Composable reutilizável para representar um cartão de objetivo com imagem e título.
 */
@Composable
fun ObjetivoCard(
    titulo: String,
    imagem: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imagem),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = titulo,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}