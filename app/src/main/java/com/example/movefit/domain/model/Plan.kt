package pt.ipca.movefit.domain.model

/**
 * Modelo de domínio que representa um plano de treino.
 * Utilizado pela camada de negócio e pela apresentação (ViewModel / UI).
 */
data class Plan(
    val id: String = "",         // ✅ Corrigido para String (compatível com timestamp)
    val titulo: String,          // Título do plano de treino
    val objetivo: String,        // Objetivo do plano (ex: Perder peso, Ganhar massa)
    val nivel: String            // Nível de dificuldade (ex: Iniciante, Intermédio, Avançado)
)
