package pt.ipca.movefit.presentation.login

import androidx.activity.ComponentActivity
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.Routes.LOGIN_ROUTE // ✅ Correção da importação
import pt.ipca.movefit.presentation.Routes.VERIFY_CODE_ROUTE // ✅ Correção da importação

/**
 * Ecrã para recuperação de palavra-passe.
 * O utilizador introduz o seu email para receber um código de verificação.
 */
@Composable
fun RecoverPasswordScreen(navController: NavController) {
    // Definição das cores do tema
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)
    val lightGray = Color(0xFFAAAAAA)

    // Estado do campo de email
    var email by remember { mutableStateOf("") }

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        // Ícones no topo: logout e definições
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
                    .clickable { activity?.finishAffinity() } // ✅ Fecha a app
            )
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Definições",
                tint = darkGreen,
                modifier = Modifier.size(32.dp)
            )
        }

        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Campo de email
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .shadow(2.dp, RoundedCornerShape(8.dp))
                    .background(white, shape = RoundedCornerShape(8.dp))
                    .border(2.dp, lightGray, shape = RoundedCornerShape(8.dp))
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = {
                        Text("Email", fontSize = 14.sp, color = Color.Gray)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = white,
                        focusedContainerColor = white,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Texto informativo
            Text(
                text = "Texto informativo: \"Receberás um e-mail com um código para redefinir a tua palavra-passe\"",
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Link para voltar ao login
            Text(
                text = "Voltar ao Login",
                fontSize = 14.sp,
                color = darkGreen,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController.navigate(LOGIN_ROUTE) {
                        popUpTo(LOGIN_ROUTE) {
                            inclusive = true // ✅ Uso correto da flag
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão "Enviar Código"
            Button(
                onClick = {
                    navController.navigate(VERIFY_CODE_ROUTE) // ✅ Navega para ecrã de verificação
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
                    text = "Enviar Código",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        // Barra inferior com ícones
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
                    .clickable {
                        navController.navigate(LOGIN_ROUTE) {
                            popUpTo(LOGIN_ROUTE) {
                                inclusive = true // ✅ Correção da visibilidade
                            }
                        }
                    }
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