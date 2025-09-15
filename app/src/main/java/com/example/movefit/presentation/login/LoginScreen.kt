package pt.ipca.movefit.presentation.login

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.Routes.LOGIN_ROUTE
import pt.ipca.movefit.presentation.Routes.REGISTER_ROUTE
import pt.ipca.movefit.presentation.Routes.RECOVER_PASSWORD_ROUTE
import pt.ipca.movefit.presentation.Routes.DASHBOARD_ROUTE

/**
 * Ecrã de Login onde o utilizador pode introduzir o seu email e palavra-passe para iniciar sessão.
 */
@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    // Observar os estados do email e palavra-passe
    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.collectAsState()

    // Cores definidas no ficheiro colors.xml
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.green_primary)
    val white = colorResource(id = R.color.white)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        TopIcons() // Parte superior com ícones de logout e definições

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Logótipo da aplicação
            Image(
                painter = painterResource(id = R.drawable.andar),
                contentDescription = "Ícone Move&Fit",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Título
            Text(
                text = "Move&Fit",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de email
            CustomLoginField(
                value = email.value,
                onValueChange = { loginViewModel.onEmailChanged(it) },
                placeholder = "Email"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de palavra-passe
            CustomLoginField(
                value = password.value,
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                placeholder = "Palavra-passe",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Link para recuperar palavra-passe
            Text(
                text = "Recuperar Palavra-passe",
                color = darkGreen,
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    navController.navigate(RECOVER_PASSWORD_ROUTE)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botões: Iniciar Sessão e Criar Conta
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        navController.navigate(DASHBOARD_ROUTE) {
                            popUpTo(LOGIN_ROUTE) { inclusive = true }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = darkGreen,
                        contentColor = white
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(140.dp)
                ) {
                    Text("Iniciar Sessão", fontWeight = FontWeight.Bold, color = Color.White)
                }

                Button(
                    onClick = {
                        navController.navigate(REGISTER_ROUTE)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = darkGreen,
                        contentColor = white
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(140.dp)
                ) {
                    Text("Criar Conta", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }

        BottomIcons() // Ícones no rodapé (opcional)
    }
}

/**
 * Campo reutilizável para introdução de texto com ou sem máscara de palavra-passe.
 */
@Composable
fun CustomLoginField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    val white = colorResource(id = R.color.white)
    val lightGray = Color(0xFFAAAAAA)

    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .shadow(2.dp, RoundedCornerShape(8.dp))
            .background(white, shape = RoundedCornerShape(8.dp))
            .border(2.dp, lightGray, shape = RoundedCornerShape(8.dp))
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = placeholder, fontSize = 14.sp, color = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = white,
                focusedContainerColor = white,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
    }
}

/**
 * Ícones superiores: logout e definições.
 */
@Composable
fun TopIcons() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity
    val darkGreen = colorResource(id = R.color.green_primary)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.porta),
            contentDescription = "Logout",
            tint = darkGreen,
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    activity?.finishAffinity()
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = "Definições",
            tint = darkGreen,
            modifier = Modifier.size(32.dp)
        )
    }
}

/**
 * Espaço reservado para os ícones de navegação no fundo do ecrã.
 */
@Composable
fun BottomIcons() {
    val darkGreen = colorResource(id = R.color.green_primary)

    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
        }
    }
}