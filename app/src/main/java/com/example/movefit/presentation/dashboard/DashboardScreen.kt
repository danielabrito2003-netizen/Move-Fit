package pt.ipca.movefit.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import androidx.compose.ui.res.painterResource
import pt.ipca.movefit.R

@Composable
fun DashboardScreen(navController: NavHostController) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_green_background)) // Usando cor do XML
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Top bar com ícones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.porta),
                    contentDescription = "Logout",
                    tint = colorResource(id = R.color.green_primary),
                    modifier = Modifier.size(32.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Definições",
                    tint = colorResource(id = R.color.green_primary),
                    modifier = Modifier.size(32.dp)
                )
            }

            // Título Dashboard
            Text(
                text = "Dashboard",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            // Barra de pesquisa
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                )
                Icon(
                    painter = painterResource(id = R.drawable.search), // Ícone de lupa
                    contentDescription = "Pesquisar",
                    tint = colorResource(id = R.color.green_primary),
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Categorias de Saúde (Botões)
            Column(modifier = Modifier.fillMaxWidth()) {
                // Botão para Monitorização de Atividades
                Button(
                    onClick = { /* Lógica para navegação */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_primary)), // Usando cor do XML
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Monitorização de Atividades", color = Color.White)
                }

                // Botões restantes podem ser adicionados da mesma forma

            }
        }
    }
}