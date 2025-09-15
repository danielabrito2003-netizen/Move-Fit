package pt.ipca.movefit.domain.usecase.activity

import pt.ipca.movefit.domain.model.Activity
import pt.ipca.movefit.domain.repository.ActivityRepository

/**
 * Caso de uso responsável por registar uma nova atividade física.
 * Recebe um objeto do tipo Activity e delega ao repositório a lógica de registo.
 */
class RegisterActivityUseCase(
    private val activityRepository: ActivityRepository
) {
    /**
     * Executa o registo de uma atividade física.
     *
     * @param activity Objeto que contém os dados da atividade a registar.
     */
    suspend operator fun invoke(activity: Activity) {
        activityRepository.registerActivity(activity)
    }
}