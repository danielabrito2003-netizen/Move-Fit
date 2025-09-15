package pt.ipca.movefit.data.remote.repository

import kotlinx.coroutines.tasks.await
import pt.ipca.movefit.data.local.dao.ActivityDao
import pt.ipca.movefit.data.local.entity.ActivityEntity
import pt.ipca.movefit.data.remote.api.ActivityService
import pt.ipca.movefit.domain.model.Activity
import pt.ipca.movefit.domain.repository.ActivityRepository

/**
 * Implementação do repositório de atividades físicas.
 * Liga a camada de domínio à base de dados local (Room) e ao Firebase Realtime Database.
 *
 * @param activityDao DAO local para acesso à base de dados Room
 * @param activityService Serviço remoto para interação com o Firebase
 */
class ActivityRepositoryImpl(
    private val activityDao: ActivityDao,
    private val activityService: ActivityService
) : ActivityRepository {

    /**
     * Regista uma nova atividade física.
     * Primeiro grava localmente com Room e depois envia para o Firebase.
     *
     * @param activity Objeto com os dados da atividade a registar.
     */
    override suspend fun registerActivity(activity: Activity) {
        // 1. Guarda localmente (Room)
        val entity = ActivityEntity(
            userId = activity.userId,
            nome = activity.nome,
            tipo = activity.tipo,
            duracaoMinutos = activity.duracaoMinutos,
            calorias = activity.calorias
        )
        activityDao.inserirAtividade(entity)

        // 2. Guarda remotamente (Firebase)
        try {
            activityService.uploadActivity(activity)
        } catch (e: Exception) {
            e.printStackTrace() // 🔁 Em caso de erro no upload, não interrompe a app
        }
    }

    /**
     * Devolve todas as atividades do utilizador autenticado.
     *
     * @param userId ID do utilizador autenticado.
     * @return Lista de atividades desse utilizador (Room -> Domínio)
     */
    override suspend fun getActivitiesByUser(userId: String): List<Activity> {
        return activityDao.obterTodasAtividades()
            .filter { it.userId == userId }
            .map {
                Activity(
                    id = "", // ID do Firebase não é usado localmente
                    userId = it.userId,
                    nome = it.nome,
                    tipo = it.tipo,
                    duracaoMinutos = it.duracaoMinutos,
                    calorias = it.calorias
                )
            }
    }
}