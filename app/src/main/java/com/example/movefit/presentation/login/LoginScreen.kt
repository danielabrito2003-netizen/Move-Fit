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
import pt.ipca.movefit.presentation.RECOVER_PASSWORD_ROUTE
import pt.ipca.movefit.presentation.DASHBOARD_ROUTE
import pt.ipca.movefit.presentation.REGISTER_ROUTE
import pt.ipca.movefit.presentation.LOGIN_ROUTE

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.collectAsState()

    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.green_primary)
    val white = colorResource(id = R.color.white)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        TopIcons()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.andar),
                contentDescription = "Ícone Move&Fit",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Move&Fit",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomLoginField(
                value = email.value,
                onValueChange = { loginViewModel.onEmailChanged(it) },
                placeholder = "Email"
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginField(
                value = password.value,
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                placeholder = "Palavra-passe",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Recuperar Palavra-passe",
                color = darkGreen,
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    navController.navigate(RECOVER_PASSWORD_ROUTE)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        navController.navigate(DASHBOARD_ROUTE) {
                            popUpTo(LOGIN_ROUTE)
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

        BottomIcons()
    }
}

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