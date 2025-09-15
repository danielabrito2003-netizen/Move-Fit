package pt.ipca.movefit.data.remote.api

import com.google.firebase.database.FirebaseDatabase
import pt.ipca.movefit.domain.model.Activity

/**
 * Serviço responsável por interagir com o Firebase Realtime Database
 * para operações relacionadas com atividades físicas.
 */
class ActivityService {

    // Referência à base de dados Firebase
    private val database = FirebaseDatabase.getInstance()
    private val atividadesRef = database.getReference("atividades")

    /**
     * Envia uma atividade física para o Firebase.
     *
     * @param activity Atividade a ser enviada
     */
    fun uploadActivity(activity: Activity) {
        val id = atividadesRef.push().key ?: return
        atividadesRef.child(id).setValue(activity)
    }

    /**
     * (Opcional) Implementação futura para obter atividades do Firebase
     */
    // fun getActivities(): Task<DataSnapshot> { ... }
}