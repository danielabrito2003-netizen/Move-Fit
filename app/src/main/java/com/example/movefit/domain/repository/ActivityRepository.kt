package pt.ipca.movefit.domain.repository

import pt.ipca.movefit.domain.model.Activity

/**
 * Interface da camada de domínio responsável pela gestão de atividades físicas.
 * Define os contratos (métodos) que devem ser implementados na camada de dados (data).
 */
interface ActivityRepository {

    /**
     * Regista uma nova atividade (local + Firebase).
     * @param activity Objeto que contém os dados da atividade a ser registada.
     */
    suspend fun registerActivity(activity: Activity)

    /**
     * Obtém todas as atividades registadas por um determinado utilizador.
     * @param userId ID do utilizador cujas atividades se pretende obter.
     * @return Lista de objetos Activity.
     */
    suspend fun getActivitiesByUser(userId: String): List<Activity>
}
