package pt.ipca.movefit.domain.usecase.plan  // 🔧 Corrigido: 'plan' com letra minúscula

import pt.ipca.movefit.domain.model.Plan
import pt.ipca.movefit.domain.repository.PlanRepository

/**
 * Caso de uso responsável por gerar e guardar planos de treino.
 * Faz a ponte entre a camada de apresentação (ViewModel) e o repositório.
 *
 * @param planRepository Repositório que implementa a lógica de acesso a dados.
 */
class GeneratePlanUseCase(
    private val planRepository: PlanRepository
) {

    /**
     * Executa a operação de guardar um plano.
     *
     * @param plan Plano de treino a guardar.
     */
    suspend fun execute(plan: Plan) {
        planRepository.guardarPlano(plan)
    }

    /**
     * Obtém todos os planos disponíveis.
     *
     * @return Lista de planos existentes.
     */
    suspend fun obterPlanos(): List<Plan> {
        return planRepository.obterPlanos()
    }
}