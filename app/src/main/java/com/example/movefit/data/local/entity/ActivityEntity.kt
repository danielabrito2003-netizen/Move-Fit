package pt.ipca.movefit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidade que representa uma atividade física na base de dados local (Room).
 * Os campos mapeiam diretamente os atributos armazenados na tabela "activities".
 */
@Entity(tableName = "activities")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,               // ID gerado automaticamente (chave primária)
    val userId: String,            // ID do utilizador a quem a atividade pertence
    val nome: String,              // Nome da atividade (ex: Caminhada, Corrida)
    val tipo: String,              // Tipo da atividade (Cardio, Força, etc.)
    val duracaoMinutos: Int,       // Duração da atividade em minutos
    val calorias: Int              // Calorias queimadas durante a atividade
)