package pt.ipca.movefit.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movefit.presentation.settings.SettingsViewModel
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.LOGIN_ROUTE

@Composable
fun SettingsScreen(
    navController: NavController,
    settingsViewModel: SettingsViewModel = viewModel()
) {
    val lightGreenBackground = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)

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
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(white)
                        .clickable { navController.popBackStack() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.iconeverde),
                        contentDescription = "Logo Move&Fit",
                        tint = darkGreen,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )
                }

                Text(
                    text = "Definições",
                    fontSize = 24.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(40.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            SettingsItem(
                iconRes = R.drawable.profile,
                title = "Editar Perfil",
                onClick = { /* Navegar para editar perfil */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SettingsItem(
                iconRes = R.drawable.iconkey, // Substituto de iconekey
                title = "Alterar Palavra-passe",
                onClick = { /* Navegar para alterar palavra-passe */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.botao),
                        contentDescription = "Notificações",
                        tint = darkGreen,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Notificações",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }

                Switch(
                    checked = settingsViewModel.notificationsEnabled.value,
                    onCheckedChange = { settingsViewModel.toggleNotifications() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = white,
                        checkedTrackColor = darkGreen,
                        uncheckedThumbColor = white,
                        uncheckedTrackColor = Color.Gray
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    navController.navigate(LOGIN_ROUTE) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkGreen,
                    contentColor = white
                )
            ) {
                Text(text = "Sair", fontSize = 16.sp)
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
                painter = painterResource(id = R.drawable.seta),
                contentDescription = "Voltar",
                tint = darkGreen,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Icon(
                painter = painterResource(id = R.drawable.casa),
                contentDescription = "Início",
                tint = darkGreen,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate("dashboard") {
                            popUpTo("dashboard") { inclusive = true }
                        }
                    }
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
fun SettingsItem(
    iconRes: Int,
    title: String,
    onClick: () -> Unit
) {
    val darkGreen = colorResource(id = R.color.dark_green)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                tint = darkGreen,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                color = Color.Black,
                fontSize = 16.sp
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.seta),
            contentDescription = "Ir para $title",
            tint = darkGreen,
            modifier = Modifier.size(16.dp)
        )
    }
}