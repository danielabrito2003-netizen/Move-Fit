package pt.ipca.movefit.domain.model

/**
 * Modelo de domínio que representa uma atividade física.
 * Utilizado pela camada de negócio e pela apresentação (ViewModel / UI).
 */
data class Activity(
    val id: String = "",         // ✅ ID único da atividade (gerado pelo Firebase ou localmente)
    val userId: String,          // ID do utilizador a quem pertence a atividade
    val nome: String,            // Nome da atividade (ex: Corrida, Caminhada)
    val tipo: String,            // Tipo de atividade (Cardio, Força, Resistência...)
    val duracaoMinutos: Int,     // Duração da atividade em minutos
    val calorias: Int            // Número estimado de calorias queimadas
)