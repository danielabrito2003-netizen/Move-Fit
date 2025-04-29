package pt.ipca.movefit.presentation.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pt.ipca.movefit.R
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues

@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = viewModel()
) {
    val lightGreen = colorResource(id = R.color.light_green_background)
    val white = colorResource(id = R.color.white)
    val gray = Color.Gray

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            TopIcons()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Monitorização de Atividades",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Hoje",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            ActivityCard(
                icon = R.drawable.coracao,
                label = "Frequência cardíaca média do dia",
                value = "109",
                unit = "BPM",
                trailing = R.drawable.grafico
            )
            ActivityCard(
                icon = R.drawable.andar,
                label = "Passos",
                value = "1547",
                unit = "Passos",
                trailing = R.drawable.grafico
            )
            ActivityCard(
                icon = R.drawable.calorias,
                label = "Calorias Gastas",
                value = "157",
                unit = "Kcal",
                trailing = R.drawable.grafico
            )
            ActivityCard(
                icon = R.drawable.distancia,
                label = "Distância Percorrida",
                value = "6,7",
                unit = "Km",
                trailing = R.drawable.grafico
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Últimos 7 dias",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 64.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = white)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.calorias),
                            contentDescription = "Ícone calorias",
                            modifier = Modifier
                                .size(40.dp) // corrigido para corresponder aos restantes
                                .padding(end = 12.dp)
                        )
                        Text(
                            text = "Atividade",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Movimento",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = gray
                            )
                            Text(
                                text = "786 Kcal",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                        Column {
                            Text(
                                text = "Passos",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = gray
                            )
                            Text(
                                text = "25 306",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                        Column {
                            Text(
                                text = "Frequência cardíaca",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = gray
                            )
                            Text(
                                text = "96",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomIcons(navController)
        }
    }
}

@Composable
fun TopIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.andar),
            contentDescription = "Ícone principal",
            modifier = Modifier.size(36.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = "Definições",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun BottomIcons(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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
            modifier = Modifier.size(28.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.menu),
            contentDescription = "Menu",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun ActivityCard(
    icon: Int,
    label: String,
    value: String,
    unit: String,
    trailing: Int
) {
    val white = colorResource(id = R.color.white)
    val gray = Color.Gray

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "Ícone",
                    modifier = Modifier
                        .size(40.dp) // aumentado
                        .padding(end = 12.dp)
                )
                Column {
                    Text(
                        text = label,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = value,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = unit,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = gray
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = trailing),
                contentDescription = "Análise",
                modifier = Modifier.size(80.dp) // aumentado
            )
        }
    }
}