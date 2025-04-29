package com.example.movefit.presentation.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun SyncWearablesScreen(
    navController: NavController,
    wearableViewModel: WearableViewModel = viewModel()
) {
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
            // Top bar
            Row(
                modifier = Modifier.fillMaxWidth(),
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

            Spacer(modifier = Modifier.height(24.dp))

            // Título
            Text(
                text = "Sincronização com Dispositivos Wearables",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Bluetooth Toggle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, shape = RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(white)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bluetooth",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = wearableViewModel.bluetoothEnabled.value,
                    onCheckedChange = { wearableViewModel.toggleBluetooth() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = white,
                        checkedTrackColor = darkGreen,
                        uncheckedThumbColor = white,
                        uncheckedTrackColor = Color.Gray
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Texto informativo
            Text(
                text = "Texto informativo: \"Ligue a sua pulseira ou smartwatch para acompanhar a sua atividade em tempo real.\"",
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "OS MEUS DISPOSITIVOS",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            wearableViewModel.devices.forEach { device ->
                DeviceItem(device.name, device.connected) {
                    wearableViewModel.toggleDevice(device.name)
                }
            }
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

@Composable
fun DeviceItem(name: String, connected: Boolean, onClick: () -> Unit) {
    val darkGreen = colorResource(id = R.color.dark_green)
    val lightGray = Color(0xFFCCCCCC)
    val white = colorResource(id = R.color.white)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(white)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                text = if (connected) "Ligado" else "Sem ligação",
                fontSize = 12.sp,
                color = if (connected) darkGreen else lightGray
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.informacao),
            contentDescription = "Info",
            tint = darkGreen,
            modifier = Modifier.size(24.dp)
        )
    }
}