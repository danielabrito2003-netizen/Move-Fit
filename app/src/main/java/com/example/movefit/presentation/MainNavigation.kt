package pt.ipca.movefit.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.ipca.movefit.presentation.login.LoginScreen
import pt.ipca.movefit.presentation.login.RecoverPasswordScreen
import pt.ipca.movefit.presentation.login.VerifyCodeScreen
import pt.ipca.movefit.presentation.login.DefineNewPasswordScreen
import pt.ipca.movefit.presentation.dashboard.DashboardScreen // Adicionando o DashboardScreen

const val LOGIN_ROUTE = "login"
const val RECOVER_PASSWORD_ROUTE = "recover_password"
const val VERIFY_CODE_ROUTE = "verify_code"
const val DEFINE_NEW_PASSWORD_ROUTE = "define_new_password"
const val DASHBOARD_ROUTE = "dashboard" // Nova rota para o Dashboard

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
            DashboardScreen(navController = navController) // Passando o navController
        }
    }
}
