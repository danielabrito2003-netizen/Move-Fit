package pt.ipca.movefit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val uid: String,
    val nome: String,
    val email: String,
    val peso: Float?,
    val altura: Float?
)