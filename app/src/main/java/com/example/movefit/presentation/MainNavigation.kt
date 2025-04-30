package pt.ipca.movefit.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movefit.presentation.activity.SyncWearablesScreen
import com.example.movefit.presentation.activity.GamificationScreen
import pt.ipca.movefit.presentation.activity.StatisticsScreen
import pt.ipca.movefit.presentation.activity.ActivityScreen
import pt.ipca.movefit.presentation.dashboard.DashboardScreen
import pt.ipca.movefit.presentation.login.*
import pt.ipca.movefit.presentation.profile.EditProfileScreen
import pt.ipca.movefit.presentation.register.RegisterScreen
import pt.ipca.movefit.presentation.plan.*

const val LOGIN_ROUTE = "login"
const val RECOVER_PASSWORD_ROUTE = "recover_password"
const val VERIFY_CODE_ROUTE = "verify_code"
const val DEFINE_NEW_PASSWORD_ROUTE = "define_new_password"
const val DASHBOARD_ROUTE = "dashboard"
const val REGISTER_ROUTE = "register"
const val EDIT_PROFILE_ROUTE = "edit_profile"
const val CHANGE_PASSWORD_ROUTE = "change_password"
const val SYNC_WEARABLES_ROUTE = "sync_wearables"
const val GAMIFICATION_ROUTE = "gamification"
const val ACTIVITY_ROUTE = "activity"
const val PLAN_ROUTE = "plan"
const val PLAN_DETAIL_ROUTE = "plan_detail"
const val MASS_GAIN_ROUTE = "mass_gain"
const val RESISTANCE_ROUTE = "resistance"
const val STATISTICS_ROUTE = "statistics"
const val NUTRITION_ROUTE = "nutrition"

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
        composable(EDIT_PROFILE_ROUTE) {
            EditProfileScreen(navController = navController)
        }
        composable(CHANGE_PASSWORD_ROUTE) {
            ChangePasswordScreen(navController = navController)
        }
        composable(SYNC_WEARABLES_ROUTE) {
            SyncWearablesScreen(navController = navController)
        }
        composable(GAMIFICATION_ROUTE) {
            GamificationScreen(navController = navController)
        }
        composable(ACTIVITY_ROUTE) {
            ActivityScreen(navController = navController)
        }
        composable(PLAN_ROUTE) {
            PlanScreen(navController = navController)
        }
        composable(PLAN_DETAIL_ROUTE) {
            PlanDetailScreen(navController = navController)
        }
        composable(MASS_GAIN_ROUTE) {
            MassGainScreen(navController = navController)
        }
        composable(RESISTANCE_ROUTE) {
            ResistanceScreen(navController = navController)
        }
        composable(STATISTICS_ROUTE) {
            StatisticsScreen(navController = navController)
        }
    }
}
