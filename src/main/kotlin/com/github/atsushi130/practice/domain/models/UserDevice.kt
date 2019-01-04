package com.github.atsushi130.practice.domain.models

data class UserDevice(val id: Int, val userId: String, val device: Device)
data class Device(val osType: OS, val osVersion: OSVersion, val appVersion: AppVersion)
