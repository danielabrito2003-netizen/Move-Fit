package pt.ipca.movefit.data.remote.repository

import pt.ipca.movefit.domain.model.NutritionTip
import pt.ipca.movefit.domain.repository.NutritionRepository

/**
 * Implementação simples do NutritionRepository.
 * Fornece uma lista fixa de dicas nutricionais.
 */
class NutritionRepositoryImpl : NutritionRepository {

    /**
     * Devolve uma lista simulada de dicas nutricionais.
     *
     * @return Lista de NutritionTip.
     */
    override suspend fun getNutritionTips(): List<NutritionTip> {
        return listOf(
            NutritionTip(
                titulo = "Beber água",
                descricao = "Beber pelo menos 2 litros de água por dia ajuda na digestão e energia.",
                calorias = 0
            ),
            NutritionTip(
                titulo = "Comer frutas",
                descricao = "As frutas fornecem vitaminas essenciais e fibras.",
                calorias = 80
            ),
            NutritionTip(
                titulo = "Evitar fritos",
                descricao = "Reduz o consumo de gorduras saturadas ao evitar fritos.",
                calorias = 300
            ),
            NutritionTip(
                titulo = "Dormir bem",
                descricao = "Uma boa noite de sono melhora o metabolismo e controlo do apetite.",
                calorias = 0
            )
        )
    }
}