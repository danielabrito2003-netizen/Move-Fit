package pt.ipca.movefit.domain.model

/**
 * Modelo que representa os dados recolhidos de um wearable.
 */
data class WearableData(
    val passos: Int,            // Número de passos
    val calorias: Int,          // Calorias queimadas
    val batimentos: Int         // Batimentos cardíacos por minuto
)