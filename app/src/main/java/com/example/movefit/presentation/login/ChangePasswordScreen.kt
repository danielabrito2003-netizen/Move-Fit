package pt.ipca.movefit.presentation.login

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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.LOGIN_ROUTE

@Composable
fun ChangePasswordScreen(navController: NavController) {
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)

    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        // Ícones fixos no topo com padding extra
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 34.dp, start = 20.dp, end = 20.dp) // ✅ mais afastado do topo
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.porta),
                contentDescription = "Sair",
                tint = darkGreen,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        val activity = (navController.context as? androidx.activity.ComponentActivity)
                        activity?.finishAffinity() // ✅ Fecha a app completamente
                    }
            )
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Definições",
                tint = darkGreen,
                modifier = Modifier.size(28.dp)
            )
        }

        // Conteúdo central
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PasswordField(currentPassword, { currentPassword = it }, "Palavra-passe Atual")
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(newPassword, { newPassword = it }, "Nova palavra-passe")
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(confirmPassword, { confirmPassword = it }, "Confirmar palavra-passe")

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Voltar ao Login",
                fontSize = 14.sp,
                color = darkGreen,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController.navigate(LOGIN_ROUTE) {
                        popUpTo(LOGIN_ROUTE) { inclusive = true }
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // TODO: validar e alterar palavra-passe
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkGreen,
                    contentColor = white
                ),
                modifier = Modifier
                    .height(48.dp)
                    .width(220.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Alterar Palavra-passe",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        // Barra de navegação inferior
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
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    val white = colorResource(id = R.color.white)
    val strongerGray = Color(0xFFAAAAAA) // Cinzento visível

    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f) // Largura reduzida
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(white)
            .border(width = 2.dp, color = strongerGray, shape = RoundedCornerShape(8.dp))
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 14.sp,
                    color = Color.Gray // ✅ Apenas cor cinzento, sem negrito
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = white,
                focusedContainerColor = white,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
    }
}
