package pt.ipca.movefit.domain.repository

import pt.ipca.movefit.domain.model.NutritionTip

/**
 * Interface da camada de domínio responsável por fornecer dicas nutricionais.
 * Define o contrato que qualquer implementação (ex: mock ou Firebase) deve cumprir.
 */
interface NutritionRepository {

    /**
     * Obtém uma lista de dicas nutricionais.
     *
     * @return Lista de objetos NutritionTip.
     */
    suspend fun getNutritionTips(): List<NutritionTip>
}
