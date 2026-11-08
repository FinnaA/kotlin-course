package com.stimmax.lessons.lesson18.homeworks
//// Задача 3 Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.
// Абстрактный класс программируемого оборудования.
abstract class ProgrammableDevice(deviceName: String) : PoweredDevice(deviceName), Programmable {


    // Переменная для хранения текущей запущенной или сохраненной программы
    var currentProgram: String = "Нет программы"

    // Имплементируем метод выбора программы
    override fun programAction(action: String) {
        if (isPowered) {
            currentProgram = action
            println(" Успешно запрограммировано действие")
        } else {
            println("Ошибка! Нельзя установить программу, устройство выключено.")
        }
    }

    // Имплементируем метод выполнения программы
    override fun execute() {
        if (isPowered) {
            if (currentProgram != "Нет программы") {
                println(" Начинаю выполнять программу")
            } else {
                println("Нечего выполнять. Программа не задана.")
            }
        } else {
            println(" Ошибка! Нельзя запустить выполнение, устройство выключено.")
        }
    }
}