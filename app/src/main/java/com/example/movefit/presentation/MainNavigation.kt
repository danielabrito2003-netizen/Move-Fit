package pt.ipca.movefit.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.ipca.movefit.presentation.login.LoginScreen

@Composable
fun MainNavigation() {
    // Controlador de navegação que gere os ecrãs
    val navController: NavHostController = rememberNavController()

    // Definição das rotas da aplicação
    NavHost(
        navController = navController,
        startDestination = "login" // Ecrã inicial
    ) {
        composable("login") {
            // Chamada ao ecrã de login
            LoginScreen()
        }

        // Futuramente aqui serão adicionadas mais rotas (dashboard, registo, etc.)
    }
}
