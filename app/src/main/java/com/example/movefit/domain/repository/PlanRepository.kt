package pt.ipca.movefit.domain.repository

import pt.ipca.movefit.domain.model.Plan

/**
 * Interface responsável pela gestão de planos de treino.
 * Define as operações que podem ser realizadas na camada de domínio.
 */
interface PlanRepository {

    /**
     * Guarda um plano de treino (localmente ou remotamente).
     *
     * @param plan Plano de treino a guardar.
     */
    suspend fun guardarPlano(plan: Plan)

    /**
     * Obtém todos os planos guardados.
     *
     * @return Lista de planos existentes.
     */
    suspend fun obterPlanos(): List<Plan>
}