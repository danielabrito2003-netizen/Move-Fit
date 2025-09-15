package pt.ipca.movefit.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// ✅ Rotas (ficheiro Routes.kt está em pt.ipca.movefit.presentation)
import pt.ipca.movefit.presentation.Routes.LOGIN_ROUTE
import pt.ipca.movefit.presentation.Routes.REGISTER_ROUTE
import pt.ipca.movefit.presentation.Routes.RECOVER_PASSWORD_ROUTE
import pt.ipca.movefit.presentation.Routes.VERIFY_CODE_ROUTE
import pt.ipca.movefit.presentation.Routes.DEFINE_PASSWORD_ROUTE
import pt.ipca.movefit.presentation.Routes.DASHBOARD_ROUTE
import pt.ipca.movefit.presentation.Routes.ACTIVITY_ROUTE
import pt.ipca.movefit.presentation.Routes.PLAN_ROUTE
import pt.ipca.movefit.presentation.Routes.EDIT_PROFILE_ROUTE
import pt.ipca.movefit.presentation.Routes.CHANGE_PASSWORD_ROUTE

// ✅ Screens (packages corretos no teu projeto)
import pt.ipca.movefit.presentation.login.LoginScreen
import pt.ipca.movefit.presentation.register.RegisterScreen
import pt.ipca.movefit.presentation.login.RecoverPasswordScreen
import pt.ipca.movefit.presentation.login.VerifyCodeScreen
import pt.ipca.movefit.presentation.login.DefineNewPasswordScreen
import pt.ipca.movefit.presentation.dashboard.DashboardScreen
import pt.ipca.movefit.presentation.activity.ActivityScreen
import pt.ipca.movefit.presentation.plan.PlanScreen
import pt.ipca.movefit.presentation.profile.EditProfileScreen
import pt.ipca.movefit.presentation.login.ChangePasswordScreen

/**
 * NavGraph principal da Move&Fit.
 * Orquestra as rotas da UI (sem lógica de negócio).
 */
@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LOGIN_ROUTE
    ) {
        // -------------------- AUTENTICAÇÃO --------------------

        composable(LOGIN_ROUTE) {
            LoginScreen(navController)
        }

        composable(REGISTER_ROUTE) {
            RegisterScreen(navController)
        }

        composable(RECOVER_PASSWORD_ROUTE) {
            RecoverPasswordScreen(navController)
        }

        composable(VERIFY_CODE_ROUTE) {
            VerifyCodeScreen(
                navController = navController,
                onBackToLogin = { navController.navigate(LOGIN_ROUTE) },
                onValidateCode = { navController.navigate(DEFINE_PASSWORD_ROUTE) }
            )
        }

        composable(DEFINE_PASSWORD_ROUTE) {
            DefineNewPasswordScreen(
                navController = navController,
                onBackToLogin = { navController.navigate(LOGIN_ROUTE) }
            )
        }

        // -------------------- APLICAÇÃO --------------------

        // Dashboard (não recebe NavController no teu projeto)
        composable(DASHBOARD_ROUTE) {
            DashboardScreen()
        }

        composable(ACTIVITY_ROUTE) {
            ActivityScreen(navController)
        }

        composable(PLAN_ROUTE) {
            PlanScreen()
        }

        composable(EDIT_PROFILE_ROUTE) {
            EditProfileScreen(navController)
        }

        composable(CHANGE_PASSWORD_ROUTE) {
            ChangePasswordScreen(navController)
        }
    }
}