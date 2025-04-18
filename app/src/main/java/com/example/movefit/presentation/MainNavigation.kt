package pt.ipca.movefit.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.ipca.movefit.presentation.login.LoginScreen
// ⛔️ NÃO precisas importar RecoverPasswordScreen, VerifyCodeScreen nem DefineNewPasswordScreen

// Rotas definidas como constantes
const val LOGIN_ROUTE = "login"
const val RECOVER_PASSWORD_ROUTE = "recover_password"
const val VERIFY_CODE_ROUTE = "verify_code"
const val DEFINE_NEW_PASSWORD_ROUTE = "define_new_password"

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LOGIN_ROUTE
    ) {
        // Ecrã de login
        composable(LOGIN_ROUTE) {
            LoginScreen(navController = navController)
        }

        // Ecrã de recuperação de palavra-passe
        composable(RECOVER_PASSWORD_ROUTE) {
            pt.ipca.movefit.presentation.login.RecoverPasswordScreen(navController = navController)
        }

        // Ecrã de verificação de código
        composable(VERIFY_CODE_ROUTE) {
            pt.ipca.movefit.presentation.login.VerifyCodeScreen(
                navController = navController,
                onBackToLogin = {
                    navController.popBackStack(LOGIN_ROUTE, inclusive = false)
                },
                onValidateCode = {
                    navController.navigate(DEFINE_NEW_PASSWORD_ROUTE)
                }
            )
        }

        // Ecrã para definir nova palavra-passe
        composable(DEFINE_NEW_PASSWORD_ROUTE) {
            pt.ipca.movefit.presentation.login.DefineNewPasswordScreen(
                navController = navController,
                onBackToLogin = {
                    navController.popBackStack(LOGIN_ROUTE, inclusive = false)
                }
            )
        }
    }
}