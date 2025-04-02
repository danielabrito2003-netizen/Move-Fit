```markdown
# Move&Fit - Projeto de Estágio 2025

## Autor
**Nome:** Daniela Brito  
**N.º:** 25591  
**Curso:** Licenciatura em Engenharia de Sistemas Informáticos, 3º Ano  
**U.C.:** Programação de Dispositivos Móveis  
**Docentes:** Professor Nuno F. Mendes, Professora Patrícia Leite  
**Ano:** 2024/2025  

---

## Introdução
A aplicação Move&Fit tem como objetivo promover estilos de vida mais saudáveis através da monitorização de atividades físicas e da oferta de planos de treino personalizados, com integração opcional de dispositivos **wearables**. 

A implementação é feita em **Kotlin** com **Jetpack Compose**, sem utilização de Hilt. Segue uma adaptação do padrão **Clean Architecture** dividida em três camadas principais: Presentation, Domain e Data.


## Objetivos do Projeto
- Registo e autenticação de utilizadores  
- Registo e análise de atividades físicas  
- Geração de planos de treino personalizados  
- Visualização de estatísticas  
- Personalização da experiência (notificações, lembretes, etc.)  
- Integração (opcional) com dispositivos **wearables**  
- Sugestões nutricionais e boas práticas de bem-estar  
- Sincronização de dados com **Firebase** (Autenticação e Realtime Database)  



```markdown
## Estrutura de Pastas e Ficheiros
```
MoveFit/
├── app/
│   └── src/
│       └── main/
│           ├── java/pt/ipca/movefit/
│           │   ├── presentation/                   # Camada da Interface (UI)
│           │   │   ├── login/
│           │   │   │   ├── LoginScreen.kt          # UI do ecrã de login
│           │   │   │   └── LoginViewModel.kt       # Lógica de autenticação
│           │   │   ├── register/
│           │   │   │   ├── RegisterScreen.kt       # UI para registo de novos utilizadores
│           │   │   │   └── RegisterViewModel.kt    # Validação de formulário e lógica de registo
│           │   │   ├── dashboard/
│           │   │   │   ├── DashboardScreen.kt      # Ecrã principal com acesso às funcionalidades
│           │   │   │   └── DashboardViewModel.kt   # Geração de dados para o dashboard
│           │   │   ├── activity/
│           │   │   │   ├── ActivityScreen.kt       # UI para registar e visualizar atividades
│           │   │   │   └── ActivityViewModel.kt    # Gestão de estado e envio de dados de atividade
│           │   │   ├── plan/
│           │   │   │   ├── PlanScreen.kt           # Interface dos planos de treino
│           │   │   │   └── PlanViewModel.kt        # Lógica para exibir ou gerar planos
│           │   │   ├── nutrition/
│           │   │   │   ├── NutritionScreen.kt      # UI para sugestões nutricionais
│           │   │   │   └── NutritionViewModel.kt   # Lógica para gerir dicas de nutrição
│           │   │   ├── ui/
│           │   │   │   ├── components/             # Componentes reutilizáveis (cards, botões, etc.)
│           │   │   │   └── theme/
│           │   │   │       ├── Color.kt            # Paleta de cores da app
│           │   │   │       ├── Shape.kt            # Definição de cantos e formas
│           │   │   │       ├── Theme.kt            # Configuração geral do tema
│           │   │   │       └── Type.kt             # Tipografia
│           │   │   └── MainNavigation.kt           # Gestão das rotas entre ecrãs
│           │   ├── domain/                         # Camada de negócio
│           │   │   ├── model/
│           │   │   │   ├── User.kt                 # Modelo de utilizador
│           │   │   │   ├── Activity.kt             # Modelo de atividade física
│           │   │   │   ├── Plan.kt                 # Modelo de plano de treino
│           │   │   │   ├── WearableData.kt         # Dados recebidos de wearables
│           │   │   │   └── Nutrition.kt            # Modelo de sugestão nutricional
│           │   │   ├── repository/
│           │   │   │   ├── AuthRepository.kt       # Interface de autenticação
│           │   │   │   ├── ActivityRepository.kt   # Interface para atividades físicas
│           │   │   │   ├── PlanRepository.kt       # Interface para planos
│           │   │   │   ├── WearableRepository.kt   # Interface para integração com wearables
│           │   │   │   └── NutritionRepository.kt  # Interface para sugestões nutricionais
│           │   │   └── usecase/
│           │   │       ├── Auth/
│           │   │       │   └── LoginUserUseCase.kt, RegisterUserUseCase.kt  # Casos de uso de autenticação
│           │   │       ├── Activity/
│           │   │       │   └── RegisterActivityUseCase.kt, GetStatsUseCase.kt # Registo e estatísticas
│           │   │       ├── Plan/
│           │   │       │   └── GeneratePlanUseCase.kt                        # Geração de planos
│           │   │       ├── Wearable/
│           │   │       │   └── SyncWearableDataUseCase.kt                    # Sincronizar com wearables
│           │   │       └── Nutrition/
│           │   │           └── GetNutritionTipsUseCase.kt                   # Obter sugestões de nutrição
│           │   ├── data/                           # Camada de dados (local e remoto)
│           │   │   ├── local/
│           │   │   │   ├── dao/
│           │   │   │   │   ├── ActivityDao.kt      # DAO de atividades (Room)
│           │   │   │   │   └── PlanDao.kt          # DAO de planos (Room)
│           │   │   │   ├── database/
│           │   │   │   │   └── MoveFitDatabase.kt  # Configuração da base de dados Room
│           │   │   │   └── entity/
│           │   │   │       ├── ActivityEntity.kt   # Entidade local de atividade
│           │   │   │       ├── PlanEntity.kt       # Entidade local de plano
│           │   │   │       └── UserEntity.kt       # Entidade local de utilizador
│           │   │   ├── remote/
│           │   │   │   ├── api/
│           │   │   │   │   ├── AuthService.kt      # Operações com Firebase Auth
│           │   │   │   │   ├── ActivityService.kt  # Comunicação com Firebase DB (atividades)
│           │   │   │   │   └── PlanService.kt      # Comunicação com Firebase DB (planos)
│           │   │   │   ├── dto/
│           │   │   │   │   ├── AuthDto.kt          # Dados de autenticação recebidos
│           │   │   │   │   └── PlanDto.kt          # Dados de plano recebidos
│           │   │   │   └── repository/
│           │   │   │       ├── AuthRepositoryImpl.kt       # Implementação do repositório Auth
│           │   │   │       ├── ActivityRepositoryImpl.kt   # Implementação das atividades
│           │   │   │       └── PlanRepositoryImpl.kt       # Implementação dos planos
│           │   ├── firebase/
│           │   │   └── FirebaseConfig.kt           # Inicialização e configuração do Firebase
│           │   ├── MyApplication.kt                # Inicialização da app
│           │   └── MainActivity.kt                 # Entrada principal da aplicação
├── test/
│   └── pt/ipca/movefit/
│       └── android/dao/
│           └── ActivityDaoTest.kt                  # Testes de base de dados
├── .gitignore                                       # Exclusão de ficheiros sensíveis
├── README.md                                        # Documento atual de apoio ao projeto
└── build.gradle.kts                                 # Ficheiro de configuração do projeto
```


## Fluxo de Dados

### 1. Início da Aplicação
- O ciclo inicia-se em `MainActivity.kt`, que invoca o `MainNavigation.kt`.
- A navegação entre os ecrãs é controlada por rotas definidas em `MainNavigation.kt`.

### 2. Autenticação com Firebase
- O utilizador interage com `LoginScreen.kt`, que invoca o `LoginViewModel.kt`.
- O ViewModel chama o `LoginUserUseCase.kt`, que usa `AuthRepositoryImpl.kt`, ligado ao `AuthService.kt` (Firebase Auth).

### 3. Registo de Utilizadores
- `RegisterScreen.kt` interage com `RegisterViewModel.kt`, que chama `RegisterUserUseCase.kt` e comunica com o Firebase Auth.

### 4. Após Login: Dashboard
- O `DashboardScreen.kt` apresenta atalhos para funcionalidades principais: atividades, planos e nutrição.

### 5. Registo de Atividades
- O utilizador acede a `ActivityScreen.kt`, gerido por `ActivityViewModel.kt`.
- Os dados vão para `RegisterActivityUseCase.kt` e `ActivityRepositoryImpl.kt`, que os envia para Room e Firebase Realtime DB via `ActivityService.kt`.

### 6. Geração de Planos
- `PlanViewModel.kt` chama `GeneratePlanUseCase.kt`, que interage com `PlanRepositoryImpl.kt`.
- Os dados podem ser sincronizados com o Firebase via `PlanService.kt`.

### 7. Nutrição e Sugestões
- `NutritionViewModel.kt` usa `GetNutritionTipsUseCase.kt` para devolver recomendações estáticas.

### 8. Integração com Wearables
- `SyncWearableDataUseCase.kt` poderá usar sensores locais ou APIs de terceiros para recolher dados e integrá-los.

---

## Conclusão
Este projeto Move&Fit segue uma arquitetura clara, modular e adaptada à realidade académica da licenciatura, promovendo uma implementação eficiente dos requisitos essenciais, com possibilidade de expansão futura para funcionalidades avançadas.
```

---

Se quiseres, posso já gerar o `FirebaseConfig.kt` e os ficheiros base para começar o código. Queres que o faça agora?