package pt.ipca.movefit.data.remote.repository

import pt.ipca.movefit.domain.model.WearableData
import pt.ipca.movefit.domain.repository.WearableRepository

/**
 * Implementação do repositório de dados dos wearables (versão mock).
 * Utiliza uma variável interna para simular persistência de um único registo.
 */
class WearableRepositoryImpl : WearableRepository {

    // Simulação de armazenamento local em memória (mock)
    private var lastWearableData: WearableData? = null

    /**
     * Guarda os dados recolhidos de um wearable.
     *
     * @param data Dados de passos, calorias e batimentos.
     */
    override suspend fun syncWearableData(data: WearableData) {
        lastWearableData = data
    }

    /**
     * Devolve os dados mais recentes sincronizados.
     *
     * @param userId Ignorado nesta implementação mock.
     * @return Último registo guardado ou null.
     */
    override suspend fun getLatestWearableData(userId: String): WearableData? {
        return lastWearableData
    }
}