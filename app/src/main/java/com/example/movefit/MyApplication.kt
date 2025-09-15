package pt.ipca.movefit

import android.app.Application
import com.google.firebase.FirebaseApp
import pt.ipca.movefit.data.local.database.MoveFitDatabase

// Repositórios (implementações concretas)
import pt.ipca.movefit.data.remote.repository.ActivityRepositoryImpl
import pt.ipca.movefit.data.remote.repository.AuthRepositoryImpl
import pt.ipca.movefit.data.remote.repository.PlanRepositoryImpl
import pt.ipca.movefit.data.remote.repository.UserRepositoryImpl
import pt.ipca.movefit.data.remote.repository.NutritionRepositoryImpl
import pt.ipca.movefit.data.remote.repository.WearableRepositoryImpl

// Interfaces dos repositórios (camada de domínio)
import pt.ipca.movefit.domain.repository.ActivityRepository
import pt.ipca.movefit.domain.repository.AuthRepository
import pt.ipca.movefit.domain.repository.PlanRepository
import pt.ipca.movefit.domain.repository.UserRepository
import pt.ipca.movefit.domain.repository.NutritionRepository
import pt.ipca.movefit.domain.repository.WearableRepository

// Casos de uso (UseCases)
import pt.ipca.movefit.domain.usecase.activity.RegisterActivityUseCase
import pt.ipca.movefit.domain.usecase.activity.GetStatsUseCase
import pt.ipca.movefit.domain.usecase.auth.LoginUserUseCase
import pt.ipca.movefit.domain.usecase.auth.RegisterUserUseCase
import pt.ipca.movefit.domain.usecase.plan.GeneratePlanUseCase
import pt.ipca.movefit.domain.usecase.nutrition.GetNutritionTipsUseCase
import pt.ipca.movefit.domain.usecase.wearable.SyncWearableDataUseCase

// Serviços externos (ex: Firebase)
import pt.ipca.movefit.data.remote.api.ActivityService
import pt.ipca.movefit.data.remote.api.PlanService

/**
 * Classe principal da aplicação.
 * Responsável pela inicialização global de:
 * - Firebase
 * - Room (base de dados local)
 * - Repositórios (camada de dados)
 * - Casos de uso (domínio)
 */
class MyApplication : Application() {

    companion object {
        // Instância global da aplicação
        lateinit var instance: MyApplication
            private set

        // Base de dados Room
        lateinit var database: MoveFitDatabase
            private set

        // Repositórios (injeção manual)
        lateinit var authRepository: AuthRepository
        lateinit var userRepository: UserRepository
        lateinit var activityRepository: ActivityRepository
        lateinit var planRepository: PlanRepository
        lateinit var nutritionRepository: NutritionRepository
        lateinit var wearableRepository: WearableRepository

        // Casos de uso (UseCases)
        lateinit var loginUserUseCase: LoginUserUseCase
        lateinit var registerUserUseCase: RegisterUserUseCase
        lateinit var registerActivityUseCase: RegisterActivityUseCase
        lateinit var getStatsUseCase: GetStatsUseCase
        lateinit var generatePlanUseCase: GeneratePlanUseCase
        lateinit var getNutritionTipsUseCase: GetNutritionTipsUseCase
        lateinit var syncWearableDataUseCase: SyncWearableDataUseCase
    }

    override fun onCreate() {
        super.onCreate()

        // Guardar instância da aplicação
        instance = this

        // Inicializar Firebase (auth + realtime database)
        FirebaseApp.initializeApp(this)

        // Inicializar Room (base de dados local)
        database = MoveFitDatabase.getInstance(this)

        // Inicializar repositórios com DAO e serviços remotos
        authRepository = AuthRepositoryImpl()
        userRepository = UserRepositoryImpl()
        activityRepository = ActivityRepositoryImpl(
            database.activityDao(),
            ActivityService()
        )
        planRepository = PlanRepositoryImpl(
            database.planDao(),
            PlanService()
        )
        nutritionRepository = NutritionRepositoryImpl()
        wearableRepository = WearableRepositoryImpl()

        // Inicializar casos de uso (UseCases)
        loginUserUseCase = LoginUserUseCase(authRepository)
        registerUserUseCase = RegisterUserUseCase(authRepository)
        registerActivityUseCase = RegisterActivityUseCase(activityRepository)
        getStatsUseCase = GetStatsUseCase(activityRepository)
        generatePlanUseCase = GeneratePlanUseCase(planRepository)
        getNutritionTipsUseCase = GetNutritionTipsUseCase(nutritionRepository)
        syncWearableDataUseCase = SyncWearableDataUseCase(wearableRepository)
    }
}