package pt.ipca.movefit.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.ipca.movefit.R

/**
 * Ecrã de Login da aplicação Move&Fit.
 * Segue a arquitetura MVVM e utiliza o LoginViewModel para gerir o estado.
 */
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    // Estado atual dos campos de texto
    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_green_background))
    ) {
        // Ícone da porta (logout)
        IconButton(
            onClick = { /* ação logout */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 36.dp, start = 12.dp) // ajustado
        ) {
            Icon(
                painter = painterResource(id = R.drawable.porta),
                contentDescription = "Logout",
                tint = colorResource(id = R.color.green_primary)
            )
        }

        // Ícone das definições
        IconButton(
            onClick = { /* ação definições */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 36.dp, end = 12.dp) // ajustado
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Definições",
                tint = colorResource(id = R.color.green_primary)
            )
        }

        // Coluna principal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logótipo do utilizador a andar
            Image(
                painter = painterResource(id = R.drawable.andar),
                contentDescription = "Ícone Move&Fit",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Título da app
            Text(
                text = "Move&Fit",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campo de email
            OutlinedTextField(
                value = email.value,
                onValueChange = { loginViewModel.onEmailChanged(it) },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )

            // Campo de palavra-passe
            OutlinedTextField(
                value = password.value,
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                label = { Text("Palavra-passe") },
                modifier = Modifier.fillMaxWidth()
            )

            // Link "Recuperar Palavra-passe"
            ClickableText(
                text = AnnotatedString("Recuperar Palavra-passe"),
                onClick = { /* ação recuperar password */ },
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 24.dp),
                style = LocalTextStyle.current.copy(
                    color = colorResource(id = R.color.green_primary),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            )

            // Botões de ação lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { loginViewModel.onLoginClicked() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green_primary)
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Iniciar Sessão", color = Color.White)
                }

                Button(
                    onClick = { /* ação criar conta */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green_primary)
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Criar Conta", color = Color.White)
                }
            }
        }
    }
}