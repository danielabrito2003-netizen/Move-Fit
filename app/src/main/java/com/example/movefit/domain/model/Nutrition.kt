package pt.ipca.movefit.domain.model

/**
 * Modelo de domínio que representa uma dica nutricional.
 */
data class NutritionTip(
    val titulo: String,         // Título da dica (ex: Beber água)
    val descricao: String,      // Descrição ou justificação da dica
    val calorias: Int           // Calorias estimadas ou associadas
)