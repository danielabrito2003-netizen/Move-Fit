# Move&Fit

Academic Android application developed as part of the **Mobile Device Programming** course of the Computer Systems Engineering degree.

## 📌 About the Project

**Move&Fit** is a mobile fitness application designed to promote healthier lifestyles by supporting physical activity tracking, workout plan management and nutrition-related information.

The application was developed in **Kotlin** using **Jetpack Compose** and follows an adaptation of **Clean Architecture**, separating the project into Presentation, Domain and Data layers.

## ✨ Main Features

- User registration and authentication
- Physical activity registration and tracking
- Workout plan management
- Activity statistics
- Nutrition tips and recommendations
- User dashboard
- Local data persistence
- Data synchronization with Firebase
- Structure prepared for future integration with wearable devices

## 🛠 Technologies

- Kotlin
- Android
- Jetpack Compose
- Firebase Authentication
- Firebase Realtime Database
- Room
- Retrofit
- Gson
- OkHttp
- AndroidX
- Material 3
- Git & GitHub

## 🏗 Architecture

Move&Fit follows an adaptation of **Clean Architecture**, organized into three main layers:

- **Presentation** — Screens, ViewModels, UI components and navigation
- **Domain** — Models, repository interfaces and use cases
- **Data** — Local and remote data sources, repositories and database management

This separation helps maintain a modular structure and a clear separation of responsibilities.

## 📂 Project Structure

```text
MoveFit/
│
├── app/
│   └── src/
│       └── main/
│           └── java/pt/ipca/movefit/
│
│               ├── presentation/                   # Camada da Interface (UI)
│               │   ├── login/
│               │   │   ├── LoginScreen.kt          # UI do ecrã de login
│               │   │   └── LoginViewModel.kt       # Lógica de autenticação
│               │   │
│               │   ├── register/
│               │   │   ├── RegisterScreen.kt       # UI para registo de novos utilizadores
│               │   │   └── RegisterViewModel.kt    # Validação de formulário e lógica de registo
│               │   │
│               │   ├── dashboard/
│               │   │   ├── DashboardScreen.kt      # Ecrã principal com acesso às funcionalidades
│               │   │   └── DashboardViewModel.kt   # Geração de dados para o dashboard
│               │   │
│               │   ├── activity/
│               │   │   ├── ActivityScreen.kt       # UI para registar e visualizar atividades
│               │   │   └── ActivityViewModel.kt    # Gestão de estado e envio de dados de atividade
│               │   │
│               │   ├── plan/
│               │   │   ├── PlanScreen.kt           # Interface dos planos de treino
│               │   │   └── PlanViewModel.kt        # Lógica para exibir ou gerar planos
│               │   │
│               │   ├── nutrition/
│               │   │   ├── NutritionScreen.kt      # UI para sugestões nutricionais
│               │   │   └── NutritionViewModel.kt   # Lógica para gerir dicas de nutrição
│               │   │
│               │   ├── ui/
│               │   │   ├── components/             # Componentes reutilizáveis (cards, botões, etc.)
│               │   │   └── theme/
│               │   │       ├── Color.kt            # Palete de cores da app
│               │   │       ├── Shape.kt            # Definição de cantos e formas
│               │   │       ├── Theme.kt            # Configuração geral do tema
│               │   │       └── Type.kt             # Tipografia
│               │   │
│               │   └── MainNavigation.kt           # Gestão das rotas entre ecrãs
│               │
│               ├── domain/                         # Camada de negócio
│               │   ├── model/
│               │   │   ├── User.kt                 # Modelo de utilizador
│               │   │   ├── Activity.kt             # Modelo de atividade física
│               │   │   ├── Plan.kt                 # Modelo de plano de treino
│               │   │   ├── WearableData.kt         # Dados recebidos de wearables
│               │   │   └── Nutrition.kt            # Modelo de sugestão nutricional
│               │   │
│               │   ├── repository/
│               │   │   ├── AuthRepository.kt       # Interface de autenticação
│               │   │   ├── ActivityRepository.kt   # Interface para atividades físicas
│               │   │   ├── PlanRepository.kt       # Interface para planos
│               │   │   ├── WearableRepository.kt   # Interface para integração com wearables
│               │   │   └── NutritionRepository.kt  # Interface para sugestões nutricionais
│               │   │
│               │   └── usecase/
│               │       ├── Auth/
│               │       │   └── LoginUserUseCase.kt, RegisterUserUseCase.kt
│               │       │       # Casos de uso de autenticação
│               │       │
│               │       ├── Activity/
│               │       │   └── RegisterActivityUseCase.kt, GetStatsUseCase.kt
│               │       │       # Registo e estatísticas
│               │       │
│               │       ├── Plan/
│               │       │   └── GeneratePlanUseCase.kt
│               │       │       # Geração de planos
│               │       │
│               │       ├── Wearable/
│               │       │   └── SyncWearableDataUseCase.kt
│               │       │       # Sincronização com wearables
│               │       │
│               │       └── Nutrition/
│               │           └── GetNutritionTipsUseCase.kt
│               │               # Obter sugestões de nutrição
│               │
│               ├── data/                           # Camada de dados (local e remoto)
│               │   ├── local/
│               │   │   ├── dao/
│               │   │   │   ├── ActivityDao.kt      # DAO de atividades (Room)
│               │   │   │   └── PlanDao.kt          # DAO de planos (Room)
│               │   │   │
│               │   │   ├── database/
│               │   │   │   └── MoveFitDatabase.kt  # Configuração da base de dados Room
│               │   │   │
│               │   │   └── entity/
│               │   │       ├── ActivityEntity.kt   # Entidade local de atividade
│               │   │       ├── PlanEntity.kt       # Entidade local de plano
│               │   │       └── UserEntity.kt       # Entidade local de utilizador
│               │   │
│               │   ├── remote/
│               │   │   ├── api/
│               │   │   │   ├── AuthService.kt      # Operações com Firebase Auth
│               │   │   │   ├── ActivityService.kt  # Comunicação com Firebase DB (atividades)
│               │   │   │   └── PlanService.kt      # Comunicação com Firebase DB (planos)
│               │   │   │
│               │   │   └── dto/
│               │   │       ├── AuthDto.kt           # Dados de autenticação recebidos
│               │   │       └── PlanDto.kt           # Dados de plano recebidos
│               │   │
│               │   └── repository/
│               │       ├── AuthRepositoryImpl.kt       # Implementação do repositório Auth
│               │       ├── ActivityRepositoryImpl.kt   # Implementação das atividades
│               │       └── PlanRepositoryImpl.kt       # Implementação dos planos
│               │
│               ├── firebase/
│               │   └── FirebaseConfig.kt           # Inicialização e configuração do Firebase
│               │
│               ├── MyApplication.kt                # Inicialização da app
│               └── MainActivity.kt                 # Entrada principal da aplicação
│
├── test/
│   └── pt/ipca/movefit/
│       └── android/dao/
│           └── ActivityDaoTest.kt                  # Testes de base de dados
│
├── .gitignore                                      # Exclusão de ficheiros desnecessários/sensíveis
├── README.md                                       # Documentação do projeto
└── build.gradle.kts                                # Configuração do projeto
```

## 🔄 Data Flow

### 1. Application Start

The application starts in `MainActivity.kt`, which initializes the main navigation through `MainNavigation.kt`.

Navigation between screens is managed through routes defined in the application.

### 2. Authentication

The user interacts with `LoginScreen.kt`, which communicates with `LoginViewModel.kt`.

The ViewModel uses the authentication use cases and repository implementation to communicate with **Firebase Authentication**.

### 3. User Registration

`RegisterScreen.kt` interacts with `RegisterViewModel.kt`, which uses the registration use case and authentication repository to register users.

### 4. Dashboard

After authentication, `DashboardScreen.kt` provides access to the application's main areas, including activities, workout plans and nutrition.

### 5. Activity Management

Physical activities are managed through `ActivityScreen.kt` and `ActivityViewModel.kt`.

Activity information passes through the corresponding use cases and repository implementation, with support for local persistence and Firebase synchronization.

### 6. Workout Plans

`PlanViewModel.kt` interacts with the plan use cases and repository implementation to manage workout plan information.

Plan data can also be synchronized through the corresponding remote service.

### 7. Nutrition

`NutritionViewModel.kt` uses the nutrition use case to provide nutrition-related tips and recommendations.

### 8. Wearable Integration

The project includes models, repositories and use cases prepared for wearable data.

Wearable integration was considered as an **optional/future extension** and is not presented as a fully implemented feature.

## 💾 Data Management

Move&Fit uses different technologies for data management:

- **Room** for local data persistence
- **Firebase Realtime Database** for remote data synchronization
- **Firebase Authentication** for user authentication
- Repository interfaces and implementations to separate the Domain and Data layers

## 🧪 Testing

The project includes test structures for validating parts of the application's data layer, including `ActivityDaoTest.kt`.

## 🎓 Academic Context

Developed during the **2024/2025 academic year** as an academic project for the **Mobile Device Programming** course of the Computer Systems Engineering degree.

The project provided practical experience in:

- Kotlin development
- Android application development
- Jetpack Compose
- Mobile application architecture
- Firebase integration
- Local persistence with Room
- Clean Architecture concepts
- Separation of responsibilities
- Mobile UI development

## 👩‍💻 Author

**Daniela Brito**
