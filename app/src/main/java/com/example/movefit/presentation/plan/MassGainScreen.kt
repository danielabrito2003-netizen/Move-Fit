package pt.ipca.movefit.presentation.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
fun MassGainScreen(navController: NavController) {
    val lightGreen = colorResource(id = R.color.light_green_background)

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
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "Ganhar massa",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Lista de exercícios
            ExerciseCard("Passadeira", tempo = 10)
            ExerciseCard("Tríceps Cabo", series = 3, repeticoes = 15, intervalo = 30)
            ExerciseCard("Afundos (LUNGE)", series = 3, repeticoes = 15, intervalo = 30)

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