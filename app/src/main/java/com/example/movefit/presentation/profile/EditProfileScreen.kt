package pt.ipca.movefit.presentation.profile

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
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
import pt.ipca.movefit.presentation.Routes.DASHBOARD_ROUTE // ✅ Rota importada corretamente

/**
 * Ecrã de edição de perfil onde o utilizador pode alterar os seus dados pessoais.
 */
@Composable
fun EditProfileScreen(navController: NavController) {
    // Cores do tema
    val lightGreen = colorResource(id = R.color.light_green_background)
    val darkGreen = colorResource(id = R.color.dark_green)
    val white = colorResource(id = R.color.white)
    val lightGray = Color(0xFFAAAAAA)

    // Estados dos campos do formulário
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        // Ícones superiores fixos (logout e definições)
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
                    .clickable { activity?.finishAffinity() }
            )
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Definições",
                tint = darkGreen,
                modifier = Modifier.size(32.dp)
            )
        }

        // Formulário principal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar do utilizador (imagem de perfil)
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(white)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campos de entrada de dados
            ProfileField(value = name, onValueChange = { name = it }, placeholder = "Nome")
            Spacer(modifier = Modifier.height(12.dp))
            ProfileField(value = email, onValueChange = { email = it }, placeholder = "Email")
            Spacer(modifier = Modifier.height(12.dp))
            ProfileField(value = phone, onValueChange = { phone = it }, placeholder = "Telemóvel")
            Spacer(modifier = Modifier.height(12.dp))
            ProfileField(value = weight, onValueChange = { weight = it }, placeholder = "Peso")
            Spacer(modifier = Modifier.height(12.dp))
            ProfileField(value = height, onValueChange = { height = it }, placeholder = "Altura")

            Spacer(modifier = Modifier.height(16.dp))

            // Link para voltar ao dashboard
            Text(
                text = "Voltar",
                color = darkGreen,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController.navigate(DASHBOARD_ROUTE) {
                        popUpTo(DASHBOARD_ROUTE) { inclusive = true } // ✅ Remove o ecrã atual da pilha
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para guardar alterações (não funcional por agora)
            Button(
                onClick = {
                    // TODO: Guardar alterações no perfil do utilizador
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkGreen,
                    contentColor = white
                ),
                modifier = Modifier
                    .height(48.dp)
                    .width(200.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Guardar Alterações",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        // Barra de navegação inferior (voltar, casa, menu)
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

/**
 * Campo reutilizável para edição de dados do perfil.
 */
@Composable
fun ProfileField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
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
            singleLine = true
        )
    }
}
