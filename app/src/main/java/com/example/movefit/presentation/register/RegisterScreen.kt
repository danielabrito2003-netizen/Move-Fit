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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
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
    val lightGreenBackground = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)
    val lightGray = Color(0xFFAAAAAA)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(white)
                        .clickable {}
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.porta),
                        contentDescription = "Logo Move&Fit",
                        tint = darkGreen,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {}
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

            RegisterTextField(registerViewModel.email.value, { registerViewModel.updateEmail(it) }, "Email")
            Spacer(modifier = Modifier.height(12.dp))
            RegisterTextField(registerViewModel.password.value, { registerViewModel.updatePassword(it) }, "Palavra-passe", isPassword = true)
            Spacer(modifier = Modifier.height(12.dp))
            RegisterTextField(registerViewModel.confirmPassword.value, { registerViewModel.updateConfirmPassword(it) }, "Confirmar palavra-passe", isPassword = true)
            Spacer(modifier = Modifier.height(12.dp))
            RegisterTextField(registerViewModel.phone.value, { registerViewModel.updatePhone(it) }, "Telemóvel")
            Spacer(modifier = Modifier.height(12.dp))
            RegisterTextField(registerViewModel.birthDate.value, { registerViewModel.updateBirthDate(it) }, "Data de nascimento")
            Spacer(modifier = Modifier.height(12.dp))
            RegisterTextField(registerViewModel.weight.value, { registerViewModel.updateWeight(it) }, "Peso")
            Spacer(modifier = Modifier.height(12.dp))
            RegisterTextField(registerViewModel.height.value, { registerViewModel.updateHeight(it) }, "Altura")

            Spacer(modifier = Modifier.height(24.dp))

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

            Button(
                onClick = {
                    registerViewModel.register {
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
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
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
fun RegisterTextField(
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
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(white)
            .border(width = 2.dp, color = lightGray, shape = RoundedCornerShape(8.dp))
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = white,
                focusedContainerColor = white,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}
