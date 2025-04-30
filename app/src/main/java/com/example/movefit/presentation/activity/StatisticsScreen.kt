package pt.ipca.movefit.presentation.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pt.ipca.movefit.R

@Composable
fun StatisticsScreen(navController: NavController) {
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ícones superiores com padding extra (status bar safe)
            Spacer(modifier = Modifier.height(24.dp)) // ⬅️ maior espaçamento do topo

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
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

            // Título com mais espaçamento inferior
            Spacer(modifier = Modifier.height(4.dp)) // desce um pouco mais
            Text(
                text = "Análise de Estatísticas e Desempenho",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(0.2f)) // centro vertical

            Image(
                painter = painterResource(id = R.drawable.grafico),
                contentDescription = "Gráfico",
                modifier = Modifier.size(300.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatCircle("39", "Calorias Gastas")
                    StatCircle("30", "Média de Passos")
                }

                Spacer(modifier = Modifier.height(20.dp))

                StatCircle("40", "Tempo Ativo")
            }

            Spacer(modifier = Modifier.weight(0.4f))
        }

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
fun StatCircle(valor: String, descricao: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(3.dp, color = Color(0xFF007A0E), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = valor,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = descricao,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}