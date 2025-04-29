// WearableViewModel.kt
package com.example.movefit.presentation.activity

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WearableViewModel : ViewModel() {

    var bluetoothEnabled = mutableStateOf(false)
        private set

    var devices = mutableStateListOf(
        Device("Apple Watch S8", true),
        Device("Fitbit", false),
        Device("Garmin", false)
    )
        private set

    fun toggleBluetooth() {
        bluetoothEnabled.value = !bluetoothEnabled.value
    }

    fun toggleDeviceConnection(index: Int) {
        val currentDevice = devices[index]
        devices[index] = currentDevice.copy(connected = !currentDevice.connected)
    }

    fun toggleDevice(name: String) {

    }
}

data class Device(
    val name: String,
    val connected: Boolean
)
