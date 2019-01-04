package com.github.atsushi130.practice.domain.shared

import com.github.atsushi130.practice.domain.models.Device
import org.springframework.stereotype.Component

@Component
class DeviceContainer {

    // MEMO: want to change private set, but can not modify final.
    val device: Device
        get() = this.requestDevice

    private lateinit var requestDevice: Device

    fun setRequestDevice(device: Device) {
        this.requestDevice = device
    }
}
