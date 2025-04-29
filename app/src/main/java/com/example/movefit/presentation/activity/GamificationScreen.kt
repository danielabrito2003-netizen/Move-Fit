package com.example.movefit.presentation.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
fun GamificationScreen(navController: NavController) {
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        // Top icons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.porta),
                contentDescription = "Logo",
                tint = darkGreen,
                modifier = Modifier.size(32.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Definições",
                tint = darkGreen,
                modifier = Modifier.size(28.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Gamificação e Desafios",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp, // Pequeno aumento
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Os teus desafios e conquistas",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        // Imagem centrada
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.medalha),
                contentDescription = "Medalhas",
                modifier = Modifier
                    .size(300.dp) // Aumentei o tamanho da imagem
                    .clip(CircleShape)
            )
        }

        // Barra inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(lightGreen)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.seta2),
                contentDescription = "Voltar",
                tint = darkGreen,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { navController.popBackStack() }
            )

            Icon(
                painter = painterResource(id = R.drawable.casa),
                contentDescription = "Início",
                tint = darkGreen,
                modifier = Modifier.size(40.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                tint = darkGreen,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
