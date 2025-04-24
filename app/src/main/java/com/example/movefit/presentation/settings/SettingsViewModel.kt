package com.example.movefit.presentation.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * ViewModel para o ecrã de definições
 * Responsável por gerir o estado das configurações do utilizador
 */
class SettingsViewModel : ViewModel() {

    // Estado para a opção de notificações
    val notificationsEnabled = mutableStateOf(true)

    /**
     * Alterna o estado de ativação das notificações
     */
    fun toggleNotifications() {
        notificationsEnabled.value = !notificationsEnabled.value
    }

    // Em uma implementação real, aqui teriam métodos para salvar
    // as configurações no repositório e sincronizar com o backend

    /**
     * Efetua o logout do utilizador
     * Em uma implementação real, comunicaria com o repositório de autenticação
     */
    fun logout() {
        // Em um projeto real, aqui seria implementada a lógica de logout
        // Exemplo: authRepository.logout()
    }
}