package pt.ipca.movefit.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pt.ipca.movefit.R

@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = viewModel()
) {
    // Utilizar cores definidas no arquivo colors.xml
    val lightGreenBackground = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)
    val black = colorResource(id = R.color.black)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            // Barra superior com ícones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Quadrado verde à esquerda
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(darkGreen)
                )

                // Ícone de engrenagem (configurações) à direita
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Configurações",
                    tint = darkGreen,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Título Dashboard à esquerda, quadrado verde à direita
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dashboard",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = black
                )

                // Quadrado verde à direita
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(darkGreen)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Barra de pesquisa com sombra e lupa à direita
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(28.dp))
                    .clip(RoundedCornerShape(28.dp))
                    .background(Color.White)
            ) {
                OutlinedTextField(
                    value = viewModel.searchQuery.value,
                    onValueChange = { viewModel.updateSearchQuery(it) },
                    placeholder = { Text("Pesquisar atividades, planos de treino...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Pesquisar",
                            tint = darkGreen
                        )
                    },
                    shape = RoundedCornerShape(28.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = white,
                        focusedContainerColor = white,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        cursorColor = Color.Gray
                    ),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Título Categorias de Saúde
            Text(
                text = "Categorias de Saúde",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de categorias com rolagem
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                // Categorias (usando valores fixos para garantir que tudo funcione)
                SimpleCategoryCard("Monitorização de Atividades", darkGreen)
                SimpleCategoryCard("Planos de Treino Personalizados", darkGreen)
                SimpleCategoryCard("Sincronização com Dispositivos Wearables", darkGreen)
                SimpleCategoryCard("Análise de Estatísticas e Desempenho", darkGreen)
                SimpleCategoryCard("Gamificação e Desafios", darkGreen)
                SimpleCategoryCard("Nutrição e Bem-estar", darkGreen)
                SimpleCategoryCard("Modo Comunitário e Social", darkGreen)

                // Espaço no final
                Spacer(modifier = Modifier.height(60.dp))
            }
        }

        // Barra de navegação inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(lightGreenBackground)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Seta para a esquerda
            Icon(
                painter = painterResource(id = R.drawable.seta),
                contentDescription = "Voltar",
                tint = darkGreen,
                modifier = Modifier.size(28.dp)
            )

            // Ícone da casa
            Icon(
                painter = painterResource(id = R.drawable.casa),
                contentDescription = "Início",
                tint = darkGreen,
                modifier = Modifier.size(40.dp)
            )

            // Ícone de menu
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                tint = darkGreen,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

// Componente simplificado para os cartões de categoria (garante quadrado verde e seta)
@Composable
fun SimpleCategoryCard(name: String, darkGreen: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { /* Ação ao clicar */ },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Quadrado verde como ícone (simples e garantido)
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(darkGreen)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Nome da categoria
                Text(
                    text = name,
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Seta para a direita (usando um ícone simples de seta)
            Icon(
                painter = painterResource(id = R.drawable.seta),
                contentDescription = "Ir para $name",
                tint = darkGreen,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}