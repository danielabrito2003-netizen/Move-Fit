package pt.ipca.movefit.presentation.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pt.ipca.movefit.R

@Composable
fun PlanDetailScreen(navController: NavController) {
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            // Top icons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.porta),
                    contentDescription = "Logout",
                    modifier = Modifier.size(32.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Definições",
                    modifier = Modifier.size(28.dp)
                )
            }

            // Título
            Text(
                text = "Perder peso",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Lista de exercícios
            ExerciseCard("Passadeira", tempo = 10)
            ExerciseCard("Prancha", series = 3, repeticoes = 8, intervalo = 30)
            ExerciseCard("ABS Crunch", series = 3, repeticoes = 20, intervalo = 30)

            Spacer(modifier = Modifier.weight(1f))
        }

        // Bottom navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(lightGreen)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.seta2),
                contentDescription = "Voltar",
                modifier = Modifier.size(28.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.casa),
                contentDescription = "Início",
                modifier = Modifier.size(40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun ExerciseCard(
    nome: String,
    tempo: Int? = null,
    series: Int? = null,
    repeticoes: Int? = null,
    intervalo: Int? = null
) {
    val white = colorResource(id = R.color.white)
    val gray = Color.Gray
    val darkGreen = colorResource(id = R.color.dark_green)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = white)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.passadeira),
                contentDescription = "Ícone exercício",
                modifier = Modifier
                    .size(48.dp) // 🔼 aumentado
                    .padding(end = 12.dp)
            )

            Column {
                Text(
                    text = nome,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp, // 🔼 maior
                    color = gray      // 🔁 cinzento
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (tempo != null) {
                    Text("Tempo: $tempo", color = Color.Black)
                } else {
                    Text("Séries: $series", color = Color.Black)
                    Text("Repetições: $repeticoes", color = Color.Black)
                    Text("Intervalo: $intervalo", color = Color.Black)
                }
            }
        }
    }
}