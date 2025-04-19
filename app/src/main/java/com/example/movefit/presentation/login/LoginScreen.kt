package pt.ipca.movefit.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.RECOVER_PASSWORD_ROUTE

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel()
) {
    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_green_background))
    ) {
        TopIcons()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.andar),
                contentDescription = "Ícone Move&Fit",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Move&Fit",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = email.value,
                onValueChange = { loginViewModel.onEmailChanged(it) },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                label = { Text("Palavra-passe") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            ClickableText(
                text = AnnotatedString("Recuperar Palavra-passe"),
                onClick = {
                    navController.navigate(RECOVER_PASSWORD_ROUTE)
                },
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 24.dp),
                style = TextStyle(
                    color = colorResource(id = R.color.green_primary),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        // Para o momento, apenas deixamos a navegação para o login
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green_primary)
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Iniciar Sessão", color = Color.White)
                }

                Button(
                    onClick = { navController.navigate("register") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green_primary)
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Criar Conta", color = Color.White)
                }
            }
        }

        BottomIcons()
    }
}

@Composable
fun TopIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp),
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
}

@Composable
fun BottomIcons() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = R.drawable.seta),
                contentDescription = "Voltar",
                tint = colorResource(id = R.color.green_primary),
                modifier = Modifier.size(32.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.andar),
                contentDescription = "Início",
                tint = colorResource(id = R.color.green_primary),
                modifier = Modifier.size(32.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                tint = colorResource(id = R.color.green_primary),
                modifier = Modifier.size(32.dp)
            )
        }
    }
}