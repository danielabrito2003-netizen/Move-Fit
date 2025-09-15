package pt.ipca.movefit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidade Room que representa um plano de treino na base de dados local.
 * Esta entidade é usada exclusivamente para persistência em SQLite através do Room.
 *
 * A tabela criada será 'plans', conforme especificado no parâmetro tableName.
 */
@Entity(tableName = "plans")
data class PlanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,             // Identificador único gerado automaticamente por Room
    val titulo: String,          // Título do plano (ex: "Plano de Perda de Peso")
    val objetivo: String,        // Objetivo do plano (ex: "Perder peso", "Ganhar massa")
    val nivel: String            // Nível de dificuldade (ex: "Iniciante", "Avançado")
)