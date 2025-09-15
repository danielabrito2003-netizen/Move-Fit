package pt.ipca.movefit.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pt.ipca.movefit.data.local.dao.ActivityDao
import pt.ipca.movefit.data.local.dao.PlanDao
import pt.ipca.movefit.data.local.entity.ActivityEntity
import pt.ipca.movefit.data.local.entity.PlanEntity
import pt.ipca.movefit.data.local.entity.UserEntity

/**
 * Base de dados local (Room) da aplicação Move&Fit.
 * Define as entidades da BD e os respetivos DAOs.
 */
@Database(
    entities = [ActivityEntity::class, PlanEntity::class, UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MoveFitDatabase : RoomDatabase() {

    // DAO para operações sobre atividades
    abstract fun activityDao(): ActivityDao

    // DAO para operações sobre planos
    abstract fun planDao(): PlanDao

    companion object {
        @Volatile
        private var INSTANCE: MoveFitDatabase? = null

        /**
         * Retorna a instância singleton da base de dados.
         * Esta instância deve ser inicializada apenas uma vez na aplicação.
         */
        fun getInstance(context: Context): MoveFitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoveFitDatabase::class.java,
                    "movefit_db"
                )
                    .fallbackToDestructiveMigration() // ⚠️ útil em caso de atualizações simples de schema
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}