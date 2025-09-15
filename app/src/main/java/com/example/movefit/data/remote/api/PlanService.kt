package pt.ipca.movefit.data.remote.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import pt.ipca.movefit.domain.model.Plan

/**
 * Serviço responsável por comunicar com o Firebase Realtime Database
 * para guardar e obter planos de treino dos utilizadores.
 */
class PlanService {

    // Instância de autenticação Firebase
    private val auth = FirebaseAuth.getInstance()

    // Referência base à coleção "planos" no Realtime Database
    private val database = FirebaseDatabase.getInstance().getReference("planos")

    /**
     * Envia um plano de treino para o Firebase Realtime Database.
     * Gera automaticamente um ID único (push) dentro do nó do utilizador.
     *
     * @param plan Plano a ser guardado.
     */
    suspend fun uploadPlan(plan: Plan) {
        val userId = auth.currentUser?.uid ?: return // Ignora se não estiver autenticado
        val planoRef = database.child(userId).push()
        planoRef.setValue(plan).await() // Operação assíncrona segura
    }

    /**
     * Obtém todos os planos guardados no Firebase para o utilizador autenticado.
     *
     * @return Lista de objetos Plan ou lista vazia se falhar.
     */
    suspend fun getPlans(): List<Plan> {
        val userId = auth.currentUser?.uid ?: return emptyList()
        val snapshot = database.child(userId).get().await()

        val planos = mutableListOf<Plan>()
        for (child in snapshot.children) {
            val plano = child.getValue(Plan::class.java)
            plano?.let { planos.add(it) } // Só adiciona se não for nulo
        }

        return planos
    }
}