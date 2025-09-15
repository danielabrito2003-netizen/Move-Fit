package pt.ipca.movefit.domain.model

/**
 * Modelo de domínio que representa um utilizador.
 */
data class User(
    val id: String,             // ID único do utilizador
    val nome: String,           // Nome do utilizador
    val email: String           // Email associado
)