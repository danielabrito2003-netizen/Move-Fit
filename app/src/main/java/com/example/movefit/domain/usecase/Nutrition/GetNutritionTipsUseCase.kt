package pt.ipca.movefit.domain.usecase.nutrition

import pt.ipca.movefit.domain.model.NutritionTip
import pt.ipca.movefit.domain.repository.NutritionRepository

/**
 * Caso de uso responsável por obter as dicas de nutrição.
 * Este caso de uso recupera uma lista de sugestões alimentares do repositório.
 */
class GetNutritionTipsUseCase(
    private val nutritionRepository: NutritionRepository
) {
    /**
     * Executa a operação de obtenção de dicas de nutrição.
     *
     * @return Lista de objetos NutritionTip.
     */
    suspend operator fun invoke(): List<NutritionTip> {
        return nutritionRepository.getNutritionTips()
    }
}