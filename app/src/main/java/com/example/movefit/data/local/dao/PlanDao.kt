package pt.ipca.movefit.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pt.ipca.movefit.data.local.entity.PlanEntity

/**
 * DAO responsável pelas operações de acesso a dados da entidade PlanEntity.
 * Utiliza Room para persistência local dos planos de treino.
 */
@Dao
interface PlanDao {

    /**
     * Insere um plano na base de dados local.
     * Em caso de conflito de ID, o plano anterior é substituído.
     *
     * @param plano Entidade que representa o plano a ser inserido.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirPlano(plano: PlanEntity)

    /**
     * Devolve todos os planos existentes na tabela 'plans'.
     *
     * @return Lista de todos os planos guardados localmente.
     */
    @Query("SELECT * FROM plans")
    suspend fun obterTodosPlanos(): List<PlanEntity>
}