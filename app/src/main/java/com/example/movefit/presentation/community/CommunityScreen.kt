package pt.ipca.movefit.presentation.community

import androidx.compose.foundation.BorderStroke // <-- IMPORT NECESSÁRIO
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.ui.theme.BackgroundLightGreen
import pt.ipca.movefit.presentation.ui.theme.BorderLightGray

@Composable
fun CommunityScreen() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = BackgroundLightGreen
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 36.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.seta2),
                        contentDescription = "Voltar",
                        tint = Color.Black,
                        modifier = Modifier.size(28.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.casa),
                        contentDescription = "Início",
                        tint = Color.Black,
                        modifier = Modifier.size(32.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu",
                        tint = Color.Black,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        },
        containerColor = BackgroundLightGreen
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título centralizado e em negrito
            Text(
                text = "Comunidade Move&Fit",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Mantém-te motivado com atividade dos teus amigos",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Cartão: Top da Semana
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp))
                    .border(BorderStroke(1.dp, BorderLightGray), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Top da Semana",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Marta 8.200 passos", fontSize = 14.sp, color = Color.Black)
                    Text("João 7.900 passos", fontSize = 14.sp, color = Color.Black)
                    Text("Sara 6.800 passos", fontSize = 14.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Cartão: Completa o Desafio
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp))
                    .border(BorderStroke(1.dp, BorderLightGray), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Completa o desafio",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Correr 5km", fontSize = 14.sp, color = Color.Black)
                    Text("Beber água 2 Litros", fontSize = 14.sp, color = Color.Black)
                    Text("Dormir 8 horas", fontSize = 14.sp, color = Color.Black)
                }
            }
        }
    }
}