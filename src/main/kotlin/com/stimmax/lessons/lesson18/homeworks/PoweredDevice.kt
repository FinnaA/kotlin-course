package com.stimmax.lessons.lesson18.homeworks
// Задача 2. Создаем абстрактный класс. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).

abstract class PoweredDevice(val deviceName: String) : Powerable {


    var isPowered: Boolean = false

    // Реализуем метод включения
    override fun powerOn() {
        if (!isPowered) {
            isPowered = true
            println(" Питание включено. Устройство готово к работе.")
        } else {
            println(" Устройство уже включено.")
        }
    }

    // Реализуем метод выключения
    override fun powerOff() {
        if (isPowered) {
            isPowered = false
            println(" Питание выключено. Устройство выключено.")
        } else {
            println(" Устройство уже выключено.")
        }
    }
}