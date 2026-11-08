package com.stimmax.lessons.lesson18.homeworks

// 3. Чайник 
class WaterKettle(name: String) : ThermalOpenableDevice(name, maxTemperature = 100), WaterContainer {
    override val capacity: Int = 2
    
    override fun fillWater(amount: Int) { println("[$deviceName]: Чайник наполнен водой на $amount литра(ов).") }
    override fun getWater(amount: Int) { println("[$deviceName]: Наливаем $amount л кипятка в кружку.") }
}