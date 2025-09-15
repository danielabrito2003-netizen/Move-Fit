package com.example.movefit.presentation.community

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class FriendRanking(
    val nome: String,
    val passos: Int
)

data class WeeklyChallenge(
    val titulo: String,
    val icone: String // podemos usar emoji por agora
)

class CommunityViewModel : ViewModel() {

    // Mock: lista de amigos com passos
    private val _ranking = MutableStateFlow(
        listOf(
            FriendRanking("Marta", 8200),
            FriendRanking("João", 7900),
            FriendRanking("Sara", 6800)
        )
    )
    val ranking: StateFlow<List<FriendRanking>> = _ranking

    // Mock: desafios da semana
    private val _desafios = MutableStateFlow(
        listOf(
            WeeklyChallenge("Correr 5km", "🏃‍♀️"),
            WeeklyChallenge("Beber 2L de água", "💧"),
            WeeklyChallenge("Dormir 8h", "😴")
        )
    )
    val desafios: StateFlow<List<WeeklyChallenge>> = _desafios
}