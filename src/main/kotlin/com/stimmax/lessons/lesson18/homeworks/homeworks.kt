package com.stimmax.lessons.lesson18.homeworks
//Интерфейсы для работы

interface Powerable {
   fun powerOn()
   fun powerOff()
}

interface Openable {
   fun open()
   fun close()
}

interface WaterContainer {
   val capacity: Int
   fun fillWater(amount: Int)
   fun getWater(amount: Int)
}

interface TemperatureRegulatable {
   val maxTemperature: Int
   fun setTemperature(temp: Int)
}

interface WaterConnection {
   fun connectToWaterSupply()
   fun getWater(amount: Int)
}

interface AutomaticShutdown {
   val sensorType: String
   val maxSensoredValue: Int
   fun startMonitoring()
}

interface Drainable {
   fun connectToDrain()
   fun drain()
}

interface Timable {
   fun setTimer(time: Int)
}

interface BatteryOperated {
   fun getCapacity(): Double
   fun replaceBattery()
}

interface Mechanical {
   fun performMechanicalAction()
}

interface LightEmitting {
   fun emitLight()
   fun completeLiteEmission()
}

interface SoundEmitting {
   fun setVolume(volume: Int)
   fun mute()
   fun playSound(stream: InputStream)
}

interface Programmable {
   fun programAction(action: String)
   fun execute()
}

interface Movable {
   fun move(direction: String, distance: Int)
}

interface Cleanable {
   fun clean()
}

interface Rechargeable {
   fun getChargeLevel(): Double
   fun recharge()
}

// 1. Холодильник

abstract class Refrigerator : Powerable, Openable, TemperatureRegulatable

// 2. Стиральная машина

abstract class WashingMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, Drainable, Timable, Programmable

// 3. Умная лампа

abstract class SmartLamp : Powerable, LightEmitting, Timable, Programmable

// 4. Электронные часы

abstract class ElectronicClock : BatteryOperated, SoundEmitting, Timable, LightEmitting

// 5. Робот-пылесос

abstract class RobotVacuum : Movable, Powerable, Rechargeable, Programmable, Cleanable

// 6. Механические часы

abstract class MechanicalClock : Mechanical, Timable

// 7. Фонарик

abstract class Flashlight : BatteryOperated, Powerable, LightEmitting

// 8. Кофемашина

abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, Timable, Programmable, WaterConnection

// 9. Умная колонка

abstract class SmartSpeaker : Powerable, SoundEmitting, LightEmitting, Timable, Programmable


fun main() {
    println("ТЕСТИРОВАНИЕ ХОЛОДИЛЬНИКА")
    val myFridge = Refrigerator("Холодильник LG")
    myFridge.powerOn()
    myFridge.setTemperature(-18) 
    myFridge.open()
    myFridge.close()
    myFridge.powerOff()

    println(" ТЕСТИРОВАНИЕ СТИРАЛЬНОЙ МАШИНЫ ")
    val washer = WashingMachine("Стиралка Bosch")
    washer.programAction("Хлопок Быстро") 
    washer.setTemperature(60)
    washer.powerOn()
    washer.connectToDrain()
    washer.fillWater(20)
    washer.setTemperature(40)
    washer.programAction("Деликатная стирка")
    washer.setTimer(45)
    washer.execute()
    washer.drain()
    washer.powerOff()

    println("ТЕСТИРОВАНИЕ ЧАЙНИКА")
    val kettle = WaterKettle("Умный чайник Tefal")
    kettle.open()
    kettle.fillWater(1)
    kettle.close()
    kettle.powerOn()
    kettle.powerOff()

    println("ТЕСТИРОВАНИЕ ДУХОВКИ")
    val oven = Oven("Духовка Gorenje")
    oven.powerOn()
    oven.setTemperature(220)
    oven.programAction("Запекание мяса")
    oven.execute()
    oven.powerOff()
}