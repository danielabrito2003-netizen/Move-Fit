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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import pt.ipca.movefit.R

@Composable
fun VerifyCodeScreen(
    navController: NavHostController,
    onBackToLogin: () -> Unit,
    onValidateCode: () -> Unit
) {
    var code by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_green_background)) // Verifique o uso correto de colorResource
    ) {
        TopIcons()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Verificação de Código",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Texto explicativo: “Introduz o código que recebeste no teu e-mail para continuar”",
                color = Color.Gray,
                fontSize = 13.sp,
                textAlign = TextAlign.Center, // Verifique se a importação de TextAlign está correta
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                label = { Text("Inserir o código") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) // Garantir que KeyboardOptions está configurado corretamente
            )

            Text(
                text = "Voltar ao Login",
                color = colorResource(id = R.color.green_primary),
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { onBackToLogin() } // Verifique se a função clickable está correta
                    .padding(bottom = 24.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { onValidateCode() },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_primary)),
                    shape = RoundedCornerShape(12.dp) // Verifique o uso correto do RoundedCornerShape
                ) {
                    Text("Validar Código", color = Color.White)
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_primary)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Reenviar Código", color = Color.White)
                }
            }
        }

        BottomIcons()
    }
}