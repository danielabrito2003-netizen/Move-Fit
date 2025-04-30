package pt.ipca.movefit.presentation.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.MASS_GAIN_ROUTE
import pt.ipca.movefit.presentation.PLAN_DETAIL_ROUTE
import pt.ipca.movefit.presentation.RESISTANCE_ROUTE // ✅ nova rota importada

@Composable
fun PlanScreen(
    navController: NavController,
    viewModel: PlanViewModel = viewModel()
) {
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 88.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Escolher Objetivo",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                GoalOption(
                    iconId = R.drawable.perderpeso,
                    label = "Perder peso",
                    onClick = {
                        viewModel.escolherObjetivo("Perder peso")
                        navController.navigate(PLAN_DETAIL_ROUTE)
                    }
                )
                GoalOption(
                    iconId = R.drawable.ganharmassa,
                    label = "Ganhar Massa",
                    onClick = {
                        viewModel.escolherObjetivo("Ganhar Massa")
                        navController.navigate(MASS_GAIN_ROUTE)
                    }
                )
                GoalOption(
                    iconId = R.drawable.resistencia,
                    label = "Resistência",
                    onClick = {
                        viewModel.escolherObjetivo("Resistência")
                        navController.navigate(RESISTANCE_ROUTE)
                    }
                )
            }
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
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.casa),
                contentDescription = "Início",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate("dashboard")
                    }
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
fun GoalOption(iconId: Int, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}