package pt.ipca.movefit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import pt.ipca.movefit.presentation.ui.MainNavigation     // ✅ import corrigido
import pt.ipca.movefit.presentation.ui.theme.MoveFitTheme // ✅ import correto para o tema

/**
 * Activity principal da aplicação Move&Fit.
 * Aplica o tema e inicializa a navegação principal.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoveFitTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    // ✅ chama o NavGraph correto
                    MainNavigation(navController = navController)
                }
            }
        }
    }
}