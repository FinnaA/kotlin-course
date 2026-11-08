package com.stimmax.lessons.lesson18.homeworks

// 2. Стиральная машина 
class WashingMachine(name: String) : ThermalOpenableDevice(name, maxTemperature = 90), WaterContainer, Drainable, Timable {
    override val capacity: Int = 50
    private var waterLevel = 0

    override fun fillWater(amount: Int) { println("[$deviceName]: Залито $amount л воды в бак.") }
    override fun getWater(amount: Int) { println("[$deviceName]: Использовано $amount л воды для стирки.") }
    override fun connectToDrain() { println("[$deviceName]: Подключено к канализации.") }
    override fun drain() { println("[$deviceName]: Слив воды из бака завершен.") }
    override fun setTimer(time: Int) { println("[$deviceName]: Таймер стирки установлен на $time минут.") }
}