package pt.ipca.movefit.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.ipca.movefit.presentation.login.LoginScreen
import pt.ipca.movefit.presentation.login.RecoverPasswordScreen
import pt.ipca.movefit.presentation.login.VerifyCodeScreen
import pt.ipca.movefit.presentation.login.DefineNewPasswordScreen
import pt.ipca.movefit.presentation.dashboard.DashboardScreen
import pt.ipca.movefit.presentation.register.RegisterScreen
import pt.ipca.movefit.presentation.settings.SettingsScreen // Importação da nova tela

// Constantes para as rotas de navegação
const val LOGIN_ROUTE = "login"
const val RECOVER_PASSWORD_ROUTE = "recover_password"
const val VERIFY_CODE_ROUTE = "verify_code"
const val DEFINE_NEW_PASSWORD_ROUTE = "define_new_password"
const val DASHBOARD_ROUTE = "dashboard"
const val REGISTER_ROUTE = "register"
const val SETTINGS_ROUTE = "settings" // Nova constante para a rota de definições

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LOGIN_ROUTE
    ) {
        composable(LOGIN_ROUTE) {
            LoginScreen(navController = navController)
        }

        composable(RECOVER_PASSWORD_ROUTE) {
            RecoverPasswordScreen(navController = navController)
        }

        composable(VERIFY_CODE_ROUTE) {
            VerifyCodeScreen(
                navController = navController,
                onBackToLogin = {
                    navController.popBackStack(LOGIN_ROUTE, inclusive = false)
                },
                onValidateCode = {
                    navController.navigate(DEFINE_NEW_PASSWORD_ROUTE)
                }
            )
        }

        composable(DEFINE_NEW_PASSWORD_ROUTE) {
            DefineNewPasswordScreen(
                navController = navController,
                onBackToLogin = {
                    navController.popBackStack(LOGIN_ROUTE, inclusive = false)
                }
            )
        }

        composable(DASHBOARD_ROUTE) {
            DashboardScreen(navController = navController)
        }

        composable(REGISTER_ROUTE) {
            RegisterScreen(navController = navController)
        }

        // Nova rota para a tela de definições
        composable(SETTINGS_ROUTE) {
            SettingsScreen(navController = navController)
        }
    }
}