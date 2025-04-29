package pt.ipca.movefit.presentation.activity

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    // Dados de hoje
    var heartRate = mutableStateOf(109)
        private set

    var steps = mutableStateOf(1547)
        private set

    var calories = mutableStateOf(157)
        private set

    var distance = mutableStateOf(6.7f)
        private set

    // Dados dos últimos 7 dias
    var last7DaysCalories = mutableStateOf(786)
        private set

    var last7DaysSteps = mutableStateOf(25306)
        private set

    var last7DaysHeartRate = mutableStateOf(96)
        private set

    // Métodos para atualizar os dados (pode ser usado com Firebase futuramente)
    fun updateHeartRate(value: Int) {
        heartRate.value = value
    }

    fun updateSteps(value: Int) {
        steps.value = value
    }

    fun updateCalories(value: Int) {
        calories.value = value
    }

    fun updateDistance(value: Float) {
        distance.value = value
    }

    fun updateLast7Days(calories: Int, steps: Int, heartRate: Int) {
        last7DaysCalories.value = calories
        last7DaysSteps.value = steps
        last7DaysHeartRate.value = heartRate
    }
}
