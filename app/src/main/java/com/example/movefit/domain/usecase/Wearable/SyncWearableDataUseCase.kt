package pt.ipca.movefit.domain.usecase.wearable

import pt.ipca.movefit.domain.model.WearableData
import pt.ipca.movefit.domain.repository.WearableRepository

/**
 * Caso de uso responsável por sincronizar ou obter dados recolhidos de um wearable.
 * Pode ser usado para atualizar o dashboard com os dados mais recentes.
 */
class SyncWearableDataUseCase(
    private val wearableRepository: WearableRepository
) {
    /**
     * Guarda os dados recolhidos (modo upload/sync).
     */
    suspend operator fun invoke(data: WearableData) {
        wearableRepository.syncWearableData(data)
    }

    /**
     * Obtém os dados mais recentes do wearable para o utilizador.
     */
    suspend operator fun invoke(userId: String): WearableData? {
        return wearableRepository.getLatestWearableData(userId)
    }
}