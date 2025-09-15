package pt.ipca.movefit.data.remote.repository

import pt.ipca.movefit.domain.model.Plan                         // Modelo de domínio
import pt.ipca.movefit.domain.repository.PlanRepository          // Interface do domínio
import pt.ipca.movefit.data.local.dao.PlanDao                    // DAO local
import pt.ipca.movefit.data.local.entity.PlanEntity              // Entidade Room
import pt.ipca.movefit.data.remote.api.PlanService               // Serviço Firebase (Realtime DB)

/**
 * Implementação do repositório de planos de treino.
 * Utiliza Room (local) e Firebase Realtime Database (remoto).
 *
 * @param planDao DAO Room para acesso à base de dados local.
 * @param planService Serviço que comunica com Firebase.
 */
class PlanRepositoryImpl(
    private val planDao: PlanDao,
    private val planService: PlanService
) : PlanRepository {

    /**
     * Guarda um plano de treino localmente (Room) e remotamente (Firebase).
     *
     * @param plan Plano a guardar.
     */
    override suspend fun guardarPlano(plan: Plan) {
        // ✅ Guardar localmente com Room
        val entity = PlanEntity(
            id = plan.id.toIntOrNull() ?: 0,
            titulo = plan.titulo,
            objetivo = plan.objetivo,
            nivel = plan.nivel
        )
        planDao.inserirPlano(entity)

        // ✅ Guardar remotamente no Firebase
        planService.uploadPlan(plan)
    }

    /**
     * Obtém todos os planos guardados localmente.
     *
     * @return Lista de planos do domínio.
     */
    override suspend fun obterPlanos(): List<Plan> {
        return planDao.obterTodosPlanos().map { plano ->
            Plan(
                id = plano.id.toString(),
                titulo = plano.titulo,
                objetivo = plano.objetivo,
                nivel = plano.nivel
            )
        }
    }
}