package com.stimmax.lessons.lesson18.homeworks

// Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
// Абстрактный класс прибора с температурой и дверцей.

abstract class ThermalOpenableDevice(deviceName: String, override val maxTemperature: Int) : 
    ProgrammableDevice(deviceName), Openable, TemperatureRegulatable {

    // Переменные для хранения текущего состояния прибора
    var isOpened: Boolean = false
    var currentTemperature: Int = 0


    override fun open() {
        if (!isOpened) {
            isOpened = true
            println("Дверца открыта.")
        } else {
            println(" Дверца уже открыта.")
        }
    }

    override fun close() {
        if (isOpened) {
            isOpened = false
            println(" Дверца закрыта.")
        } else {
            println(" Дверца уже закрыта.")
        }
    }


    override fun setTemperature(temp: Int) {
        if (!isPowered) {
            println(" Нельзя установить температуру, устройство выключено.")
            return
        }
        
        if (isOpened) {
            println("Нельзя греть с открытой дверцей")
            return
        }

        if (temp in 0..maxTemperature) {
            currentTemperature = temp
            println("Установлена температура: $currentTemperature")
        } else {
            println(" Ошибка! Неверная температура." )
        }
    }
}