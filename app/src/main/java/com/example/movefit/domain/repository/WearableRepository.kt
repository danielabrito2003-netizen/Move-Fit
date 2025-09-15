package pt.ipca.movefit.domain.repository

import pt.ipca.movefit.domain.model.WearableData

/**
 * Interface responsável por definir as operações relacionadas com a recolha e sincronização
 * de dados provenientes de dispositivos wearables.
 *
 * A implementação pode ser feita com dados mock ou através de sensores/APIs reais.
 */
interface WearableRepository {

    /**
     * Sincroniza um conjunto de dados recolhidos de um dispositivo wearable.
     *
     * @param data Dados recolhidos (passos, calorias, batimentos).
     */
    suspend fun syncWearableData(data: WearableData)

    /**
     * Obtém os dados mais recentes de um utilizador, guardados anteriormente por sync.
     *
     * @param userId ID do utilizador autenticado.
     * @return Dados mais recentes ou null, caso não existam.
     */
    suspend fun getLatestWearableData(userId: String): WearableData?
}