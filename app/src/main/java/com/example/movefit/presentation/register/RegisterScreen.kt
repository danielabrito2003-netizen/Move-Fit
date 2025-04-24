package pt.ipca.movefit.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.LOGIN_ROUTE

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel()
) {
    // Cores da aplicação
    val lightGreenBackground = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)
    val lightGray = Color(0xFFEAEAEA) // Cor cinza claro para as bordas

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 24.dp, end = 24.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Barra superior com ícones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Ícone de documento à esquerda
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(white)
                        .clickable { /* Ação para voltar */ }
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

                // Ícone de configurações à direita
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Ação de configurações */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = "Configurações",
                        tint = darkGreen,
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Campos de formulário
            RegisterTextField(
                value = registerViewModel.email.value,
                onValueChange = { registerViewModel.updateEmail(it) },
                placeholder = "Email",
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterTextField(
                value = registerViewModel.password.value,
                onValueChange = { registerViewModel.updatePassword(it) },
                placeholder = "Palavra-passe",
                isPassword = true,
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterTextField(
                value = registerViewModel.confirmPassword.value,
                onValueChange = { registerViewModel.updateConfirmPassword(it) },
                placeholder = "Confirmar palavra-passe",
                isPassword = true,
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterTextField(
                value = registerViewModel.phone.value,
                onValueChange = { registerViewModel.updatePhone(it) },
                placeholder = "Telemóvel",
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterTextField(
                value = registerViewModel.birthDate.value,
                onValueChange = { registerViewModel.updateBirthDate(it) },
                placeholder = "Data de nascimento",
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterTextField(
                value = registerViewModel.weight.value,
                onValueChange = { registerViewModel.updateWeight(it) },
                placeholder = "Peso",
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            RegisterTextField(
                value = registerViewModel.height.value,
                onValueChange = { registerViewModel.updateHeight(it) },
                placeholder = "Altura",
                lightGray = lightGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Link para iniciar sessão com "Iniciar Sessão" em verde e sublinhado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Já tens conta? ",
                    color = Color.DarkGray,
                    fontSize = 14.sp
                )

                Text(
                    text = "Iniciar Sessão",
                    color = darkGreen,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable {
                        navController.navigate(LOGIN_ROUTE) {
                            popUpTo(LOGIN_ROUTE)
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botão de criar conta
            Button(
                onClick = {
                    registerViewModel.register {
                        // Navegar para o dashboard após registo bem-sucedido
                        navController.navigate("dashboard") {
                            popUpTo(LOGIN_ROUTE)
                        }
                    }
                },
                modifier = Modifier
                    .height(48.dp)
                    .width(220.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkGreen,
                    contentColor = white
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Criar Conta",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Barra de navegação inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(lightGreenBackground)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Seta para a esquerda
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

            // Ícone da casa
            Icon(
                painter = painterResource(id = R.drawable.casa),
                contentDescription = "Início",
                tint = darkGreen,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate(LOGIN_ROUTE) {
                            popUpTo(LOGIN_ROUTE)
                        }
                    }
            )

            // Ícone de menu
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
fun RegisterTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    lightGray: Color
) {
    val white = colorResource(id = R.color.white)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(white)
            .border(width = 1.dp, color = lightGray, shape = RoundedCornerShape(8.dp))
            .padding(vertical = 2.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = white,
                focusedContainerColor = white,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            ),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None
        )
    }
}