package pt.ipca.movefit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import pt.ipca.movefit.presentation.MainNavigation
import pt.ipca.movefit.presentation.ui.theme.MoveFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ativa o modo de ecrã completo sem barra de status sobreposta
        enableEdgeToEdge()

        // Define o conteúdo principal da aplicação
        setContent {
            // Tema personalizado da aplicação
            MoveFitTheme {
                // Superfície base com a cor de fundo do tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Ponto de entrada da navegação entre ecrãs
                    MainNavigation()
                }
            }
        }
    }
}
