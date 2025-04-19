package pt.ipca.movefit.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import pt.ipca.movefit.R
import pt.ipca.movefit.presentation.VERIFY_CODE_ROUTE

@Composable
fun RecoverPasswordScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_green_background))
    ) {
        TopIcons()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Text(
                text = "Texto informativo: “Receberás um e-mail com um código para redefinir a tua palavra-passe”",
                color = Color.Gray,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Voltar ao Login",
                color = colorResource(id = R.color.green_primary),
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = { navController.navigate(VERIFY_CODE_ROUTE) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.green_primary)
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .height(48.dp)
                    .width(200.dp)
            ) {
                Text("Enviar Código", color = Color.White)
            }
        }

        BottomIcons()
    }
}