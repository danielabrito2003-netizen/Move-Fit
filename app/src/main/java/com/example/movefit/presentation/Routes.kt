package pt.ipca.movefit.presentation

/**
 * ===========================================================
 *  Routes.kt  —  Constantes das rotas de navegação da app
 * ===========================================================
 *
 * OBJETIVO:
 *  - Centralizar todas as rotas (strings) usadas no NavHost/Navigation Compose.
 *  - Evitar “erros de escrita” ao repetir literais de texto por todo o código.
 *  - Manter consistência entre a definição das rotas e a navegação nos ecrãs.
 *
 * PORQUE ESTE PACKAGE?
 *  - O projeto Move&Fit está organizado sob o package-base: pt.ipca.movefit
 *  - As rotas são usadas maioritariamente na camada presentation (navegação),
 *    por isso este ficheiro deve viver em: pt.ipca.movefit.presentation
 *  - Assim, os imports nos ecrãs ficam simples:
 *
 *      import pt.ipca.movefit.presentation.Routes.*
 *
 * COMO USAR (exemplos):
 *  1) No NavHost (MainNavigation.kt):
 *        NavHost(navController, startDestination = LOGIN_ROUTE) {
 *            composable(LOGIN_ROUTE) { LoginScreen(navController) }
 *            composable(DASHBOARD_ROUTE) { DashboardScreen(navController) }
 *        }
 *
 *  2) Ao navegar num ecrã (ex.: LoginScreen.kt):
 *        navController.navigate(DASHBOARD_ROUTE) {
 *            // Limpa a rota anterior (login) do backstack:
 *            popUpTo(LOGIN_ROUTE) { inclusive = true }
 *        }
 *
 * BOAS PRÁTICAS:
 *  - Usar SEMPRE as constantes abaixo em vez de literais ("login", "dashboard", ...).
 *  - Manter nomes curtos e sem espaços; usar snake_case se necessário.
 *  - Agrupar as rotas por “área funcional” para leitura rápida/manutenção.
 */
object Routes {

    // -------------------------------------------------------
    //  Autenticação / Login & Onboarding
    // -------------------------------------------------------

    /** Ecrã inicial de autenticação (form de email/palavra-passe). */
    const val LOGIN_ROUTE = "login"

    /** Ecrã de registo de novo utilizador. */
    const val REGISTER_ROUTE = "register"

    /** Passo 1 do fluxo de recuperação da palavra-passe: introdução do email. */
    const val RECOVER_PASSWORD_ROUTE = "recover_password"

    /** Passo 2: verificação do código enviado por email/SMS. */
    const val VERIFY_CODE_ROUTE = "verify_code"

    /** Passo 3: definir uma nova palavra-passe após verificação. */
    const val DEFINE_PASSWORD_ROUTE = "define_new_password"


    // -------------------------------------------------------
    //  Núcleo da aplicação / Dashboard + Secções principais
    // -------------------------------------------------------

    /** Ecrã principal (pós-login): cartões, atalhos e resumo. */
    const val DASHBOARD_ROUTE = "dashboard"

    /** Ecrã de registo/consulta de atividades físicas. */
    const val ACTIVITY_ROUTE = "activity"

    /** Ecrã principal de planos (seleção/entrada nos sub-planos). */
    const val PLAN_ROUTE = "plan"

    /** Ecrã para edição de dados de perfil (nome, email, peso, altura…). */
    const val EDIT_PROFILE_ROUTE = "edit_profile"

    /** Ecrã para alteração de palavra-passe (fluxo in-app, logado). */
    const val CHANGE_PASSWORD_ROUTE = "change_password"


    // -------------------------------------------------------
    //  Funcionalidades complementares (módulos extra)
    // -------------------------------------------------------

    /** Gamificação: desafios, conquistas e rankings. */
    const val GAMIFICATION_ROUTE = "gamification"

    /** Sincronização de dados com wearables / sensores. */
    const val SYNC_WEARABLES_ROUTE = "sync_wearables"

    /** Nutrição e bem-estar: refeições, dicas e hábitos. */
    const val NUTRITION_ROUTE = "nutrition"

    /** Estatísticas/analítica: gráficos, indicadores e histórico. */
    const val STATISTICS_ROUTE = "statistics"

    /** Comunidade: feed social, partilhas e interação. */
    const val COMMUNITY_ROUTE = "community"


    // -------------------------------------------------------
    //  Sub-rotas de Planos (ex.: objetivos/variações)
    // -------------------------------------------------------

    /** Sub-plano: objetivo “Ganhar Massa”. */
    const val MASS_GAIN_ROUTE = "mass_gain"

    /** Sub-plano: objetivo “Resistência”. */
    const val RESISTANCE_ROUTE = "resistance"

    /**
     * Detalhe de um plano específico.
     * Nota: se no futuro quiseres passar argumentos (ex.: ID do plano),
     *       poderás evoluir esta rota para algo como "plan_detail/{planId}"
     *       e declarar argumentos no composable correspondente.
     */
    const val PLAN_DETAIL_ROUTE = "plan_detail"
}