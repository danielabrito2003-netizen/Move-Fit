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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.ACTIVITY_ROUTE
import pt.ipca.movefit.presentation.EDIT_PROFILE_ROUTE

@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = viewModel()
) {
    val lightGreenBackground = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)
    val black = colorResource(id = R.color.black)

    var showSettingsMenu by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(true) }

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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.iconeverde),
                    contentDescription = "Logo",
                    tint = darkGreen,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )

                Box(
                    modifier = Modifier.wrapContentSize(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = "Definições",
                        tint = darkGreen,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { showSettingsMenu = true }
                    )

                    DropdownMenu(
                        expanded = showSettingsMenu,
                        onDismissRequest = { showSettingsMenu = false },
                        modifier = Modifier
                            .background(white)
                            .width(200.dp)
                    ) {
                        DropdownMenuItem(
                            text = { Text("Editar Perfil", fontSize = 14.sp, color = Color.Black) },
                            onClick = {
                                showSettingsMenu = false
                                navController.navigate(EDIT_PROFILE_ROUTE)
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = "Perfil",
                                    tint = darkGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

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

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(darkGreen)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

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

            Text(
                text = "Categorias de Saúde",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                SimpleCategoryCard("Monitorização de Atividades", darkGreen) {
                    navController.navigate(ACTIVITY_ROUTE)
                }
                SimpleCategoryCard("Planos de Treino Personalizados", darkGreen)
                SimpleCategoryCard("Sincronização com Dispositivos Wearables", darkGreen)
                SimpleCategoryCard("Análise de Estatísticas e Desempenho", darkGreen)
                SimpleCategoryCard("Gamificação e Desafios", darkGreen)
                SimpleCategoryCard("Nutrição e Bem-estar", darkGreen)
                SimpleCategoryCard("Modo Comunitário e Social", darkGreen)

                Spacer(modifier = Modifier.height(60.dp))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(lightGreenBackground)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.seta2),
                contentDescription = "Voltar",
                tint = darkGreen,
                modifier = Modifier.size(28.dp)
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

@Composable
fun SimpleCategoryCard(name: String, darkGreen: Color, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick?.invoke() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(darkGreen)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = name,
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.seta),
                contentDescription = "Ir para $name",
                tint = darkGreen,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}