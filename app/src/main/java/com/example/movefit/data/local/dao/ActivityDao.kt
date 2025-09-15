package pt.ipca.movefit.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pt.ipca.movefit.data.local.entity.ActivityEntity

/**
 * Interface DAO (Data Access Object) responsável pelas operações locais (Room)
 * relacionadas com a entidade ActivityEntity.
 */
@Dao
interface ActivityDao {

    /**
     * Insere uma nova atividade na base de dados local.
     * Em caso de conflito (mesmo ID), substitui o registo anterior.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirAtividade(atividade: ActivityEntity)

    /**
     * Retorna todas as atividades registadas na base de dados local.
     */
    @Query("SELECT * FROM activities")
    suspend fun obterTodasAtividades(): List<ActivityEntity>
}