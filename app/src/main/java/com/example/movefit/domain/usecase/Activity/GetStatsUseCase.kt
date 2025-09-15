package pt.ipca.movefit.domain.usecase.activity

import pt.ipca.movefit.domain.model.Activity
import pt.ipca.movefit.domain.repository.ActivityRepository

/**
 * Caso de uso responsável por obter as estatísticas das atividades de um utilizador.
 * Este caso de uso retorna a lista de atividades registadas localmente ou remotamente.
 */
class GetStatsUseCase(
    private val repository: ActivityRepository
) {
    /**
     * Executa a obtenção das atividades de um utilizador com base no seu ID.
     *
     * @param userId Identificador do utilizador cujas atividades serão obtidas.
     * @return Lista de atividades registadas para o utilizador.
     */
    suspend operator fun invoke(userId: String): List<Activity> {
        return repository.getActivitiesByUser(userId)
    }
}